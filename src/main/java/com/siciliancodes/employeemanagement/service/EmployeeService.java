package com.siciliancodes.employeemanagement.service;

import com.siciliancodes.employeemanagement.dto.EmployeeRequestDTO;
import com.siciliancodes.employeemanagement.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.siciliancodes.employeemanagement.dto.EmployeeRequestDTO;
import com.siciliancodes.employeemanagement.dto.EmployeeResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(UUID id);

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);

    EmployeeResponseDTO updateEmployee(UUID id, EmployeeRequestDTO dto);

    void deleteEmployee(UUID id);

    Optional<Employee> getEmployeeByEmail(String email);
}
