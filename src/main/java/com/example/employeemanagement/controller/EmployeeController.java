package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.DepartmentService;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees/list";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employees/form";
    }
    
    @PostMapping
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employees/form";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
