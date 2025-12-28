package com.siciliancodes.employeemanagement.service;

import com.siciliancodes.employeemanagement.dto.EmployeeRequestDTO;
import com.siciliancodes.employeemanagement.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(UUID id);

    Employee createEmployee(EmployeeRequestDTO dto);

    Employee updateEmployee(UUID id, EmployeeRequestDTO dto);

    void deleteEmployee(UUID id);

    Optional<Employee> getEmployeeByEmail(String email);
}
