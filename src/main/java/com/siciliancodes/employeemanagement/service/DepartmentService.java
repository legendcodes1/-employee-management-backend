package com.siciliancodes.employeemanagement.service;

import com.siciliancodes.employeemanagement.entity.Department;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Optional<Department> getDepartmentById(UUID id);

    Department createDepartment(Department department);

    Department updateDepartment(UUID id, Department department);

    void deleteDepartment(UUID id);

    Optional<Department> getDepartmentByCost(Integer cost);
}
