package com.siciliancodes.employeemanagement.service.impl;

import com.siciliancodes.employeemanagement.repository.DepartmentRepository;
import com.siciliancodes.employeemanagement.entity.Department;
import com.siciliancodes.employeemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(UUID id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(UUID id, Department department) {
        return departmentRepository.findById(id)
                .map(existing -> {
                    existing.setName(department.getName());
                    existing.setCostCenter(department.getCostCenter());
                    return departmentRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Optional<Department> getDepartmentByCost(Integer cost) {
        return departmentRepository.findByCostCenter(cost);
    }
}

