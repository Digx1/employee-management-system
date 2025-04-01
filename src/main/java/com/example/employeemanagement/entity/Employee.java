package com.example.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String email;
    
    @ManyToOne
    @JoinColumn(name ="department_id")
    private Department department;
}
