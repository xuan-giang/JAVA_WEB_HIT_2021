package com.example.btvn4.service;

import com.example.btvn4.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User createNewUser(User user);

    User getUserById(Long id);

    void removeById(Long id);

    void updateUser(User user);

    Boolean checkAccountUser(String username, String password);

    Boolean usernameIsExist(String username);
}
