package com.example.day3.controller;

import com.example.day3.model.Store;
import com.example.day3.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @GetMapping(value = { "/login"})
    public String Login(Model model) {
        return "index";
    }


    @PostMapping("/users")
    public String getUserPage(@ModelAttribute User user, Model model) {
        Store store = new Store();
        if (store.isExist(user)) {
            model.addAttribute("users", store.getUserList());
            return "users";
        }

        return "redirect:login";
    }
}
