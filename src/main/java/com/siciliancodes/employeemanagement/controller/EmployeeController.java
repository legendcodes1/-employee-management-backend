package com.siciliancodes.employeemanagement.controller;

import com.siciliancodes.employeemanagement.dto.EmployeeResponseDTO;
import com.siciliancodes.employeemanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ✅ USER: View all employees
    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // ✅ USER: View single employee
    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable UUID id) {
        return employeeService.getEmployeeById(id);
    }
}
