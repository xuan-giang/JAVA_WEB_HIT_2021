package com.example.btvn4.service;

import com.example.btvn4.model.User;
import com.example.btvn4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void removeById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean checkAccountUser(String username, String password) {
        List<User> userList = userRepository.findAll();
        for (User user: userList) {
            if(user.getUsername().compareTo(username) == 0 && user.getPassword().compareTo(password) == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean usernameIsExist(String username) {
        List<User> userList = userRepository.findAll();
        for (User user: userList) {
            if(user.getUsername().compareTo(username) == 0){
                return true;
            }
        }
        return false;
    }
}
