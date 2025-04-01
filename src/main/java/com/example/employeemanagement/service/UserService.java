package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.User;
import com.example.employeemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User registerUser(User user) {
        // Check if username already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user);
    }
    
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
