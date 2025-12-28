package com.siciliancodes.employeemanagement.controller;


import com.siciliancodes.employeemanagement.dto.DepartmentRequestDTO;
import com.siciliancodes.employeemanagement.entity.Department;
import com.siciliancodes.employeemanagement.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department createDepartment(@Valid @RequestBody DepartmentRequestDTO dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setCostCenter(dto.getCostCenter());
        return departmentService.createDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable UUID id) {
        departmentService.deleteDepartment(id);
    }
}
