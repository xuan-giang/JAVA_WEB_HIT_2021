package com.example.springbootjwtexample.service;

import com.example.springbootjwtexample.dto.UserDTO;
import com.example.springbootjwtexample.entity.User;

import java.util.List;

public interface UserService {

    User createNewUser(User user);

    List<User> getAllUser();

    List<User> getUsersList();

    void deleteUser(int id);
}
