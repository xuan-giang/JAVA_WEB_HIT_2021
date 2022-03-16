package com.example.btvn4.controller;

import com.example.btvn4.model.User;
import com.example.btvn4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/login"})
    public String Login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login-process", method = RequestMethod.POST)
    public String checkAccountUser(@ModelAttribute("user") User user) {
        if(userService.checkAccountUser(user.getUsername(), user.getPassword()))
        {
            return "redirect:/index";
        }
        return "redirect:/login";
    }
}
