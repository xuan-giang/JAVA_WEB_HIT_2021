package com.example.btvn4.controller;

import com.example.btvn4.dto.UserDTO;
import com.example.btvn4.model.User;
import com.example.btvn4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers()
    {
        return ResponseEntity.status(200).body(userRepository.findAll());
    }

    @PostMapping("/create")
    public String createNewUser(@RequestBody UserDTO userDTO)
    {
        User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFullname());

        userRepository.save(user);

        return "Created successfully!";
    }


}
