package com.example.employeemanagement.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();
        
        // Allow access to login and register pages
        if (path.startsWith("/login") || path.startsWith("/register")) {
            return true;
        }
        
        // Check if user is logged in
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
            return false;
        }
        
        return true;
    }
}
