package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments/list";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("department", new Department());
        return "departments/form";
    }
    
    @PostMapping
    public String saveDepartment(@ModelAttribute Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "departments/form";
    }
}
