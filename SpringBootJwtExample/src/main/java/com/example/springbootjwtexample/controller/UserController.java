package com.example.springbootjwtexample.controller;

import com.example.springbootjwtexample.dto.UserDTO;
import com.example.springbootjwtexample.entity.User;
import com.example.springbootjwtexample.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get")
    public ResponseEntity<?> getAllUsers()
    {
        List<User> userList = userService.getUsersList();
        return ResponseEntity.ok().body(userList.stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody User user) throws ParseException {
        User userCreated = userService.createNewUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(userCreated));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam("id") Integer id)
    {

        userService.deleteUser(id);
        return ResponseEntity.ok().body("Object is deleted successfully!");
    }

    private UserDTO convertToDto(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setAddress(user.getAddress());
        return userDTO;
    }

    private User convertToEntity(UserDTO userDTO) throws ParseException {
        User user = modelMapper.map(userDTO, User.class);

        user.setFullName(userDTO.getFullName());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        return user;
    }
}
