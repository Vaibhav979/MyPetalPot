package com.mypetalpot.LoginRegister.service;

import com.mypetalpot.LoginRegister.model.User;
import com.mypetalpot.LoginRegister.repository.UserRepository;
// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService {
    
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //Register
    public User registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
