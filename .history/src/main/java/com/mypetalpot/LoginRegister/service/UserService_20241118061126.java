package com.mypetalpot.LoginRegister.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService {
    
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder()
}