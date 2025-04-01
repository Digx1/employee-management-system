package com.example.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String username;
    
    private String password;
    
    private String fullName;
    
    private String email;
}
