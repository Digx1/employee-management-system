package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
}
