package com.mypetalpot.LoginRegister.controller;

import com.mypetalpot.LoginRegister.model.User;
import com.mypetalpot.LoginRegister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html
    }

    // login form submission
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        boolean isValid = userService.loginUser(username, password);
        if (isValid) {
            model.addAttribute("username", username);
            return "success"; // landing page.html
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    // Register page
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register"; // register.html
    }

    // Registration form submission
    @PostMapping("/register")
    public String regis(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}
