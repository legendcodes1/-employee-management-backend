package com.siciliancodes.employeemanagement.service.impl;

import com.siciliancodes.employeemanagement.dto.EmployeeRequestDTO;
import com.siciliancodes.employeemanagement.entity.Department;
import com.siciliancodes.employeemanagement.entity.Employee;
import com.siciliancodes.employeemanagement.entity.Role;
import com.siciliancodes.employeemanagement.repository.DepartmentRepository;
import com.siciliancodes.employeemanagement.repository.EmployeeRepository;
import com.siciliancodes.employeemanagement.repository.RoleRepository;
import com.siciliancodes.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository,
                               RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee createEmployee(EmployeeRequestDTO dto) {

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(department);
        employee.setRole(role);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(UUID id, EmployeeRequestDTO dto) {

        Employee existing = getEmployeeById(id);

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());

        existing.setDepartment(
                departmentRepository.findById(dto.getDepartmentId())
                        .orElseThrow(() -> new RuntimeException("Department not found"))
        );

        existing.setRole(
                roleRepository.findById(dto.getRoleId())
                        .orElseThrow(() -> new RuntimeException("Role not found"))
        );

        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
