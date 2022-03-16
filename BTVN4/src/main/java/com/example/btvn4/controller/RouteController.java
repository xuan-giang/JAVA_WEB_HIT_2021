package com.example.btvn4.controller;

import com.example.btvn4.model.User;
import com.example.btvn4.repository.UserRepository;
import com.example.btvn4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RouteController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @RequestMapping("/create")
    public String showNewUserPage(Model model) {
        User User = new User();
        model.addAttribute("User", User);

        return "create";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);

        model.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/index";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeById(id);
        return "redirect:/index";
    }
}
