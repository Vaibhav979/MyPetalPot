package com.mypetalpot.LoginRegister.controller;

import com.mypetalpot.LoginRegister.model.User;
import com.mypetalpot.LoginRegister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    //serve the 
}