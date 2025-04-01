package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.User;
import com.example.employeemanagement.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, 
                       @RequestParam String password,
                       HttpSession session,
                       Model model) {
        User user = userService.loginUser(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/";
        }
        model.addAttribute("error", "Invalid username or password");
        return "users/login";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }
    
    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        try {
            userService.registerUser(user);
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "users/register";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
