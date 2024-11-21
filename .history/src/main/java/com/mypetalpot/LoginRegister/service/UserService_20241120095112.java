package com.mypetalpot.LoginRegister.service;

import com.mypetalpot.LoginRegister.model.User;
import com.mypetalpot.LoginRegister.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Register
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    // login
    public boolean loginUser(String username, String password) {
        String pwd = passwordEncoder.encode(password
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }
}
