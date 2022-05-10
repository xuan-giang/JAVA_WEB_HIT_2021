package com.example.springbootjwtexample.service.Impl;

import com.example.springbootjwtexample.entity.User;
import com.example.springbootjwtexample.repository.UserRepository;
import com.example.springbootjwtexample.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final ModelMapper mapper;

    public UserServiceImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User createNewUser(User user) {
        //User user = mapper.map(userDto, User.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        //user.setUsername("admin");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersList() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


}
