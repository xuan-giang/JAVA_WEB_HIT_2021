package com.example.day3.controller;

import com.example.day3.model.Store;
import com.example.day3.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private Store store = new Store();

    @GetMapping("/api/users")
    public List<User> getListUser()
    {
        return store.getUserList();
    }
}
