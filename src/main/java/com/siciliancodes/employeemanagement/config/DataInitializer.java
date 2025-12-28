package com.siciliancodes.employeemanagement.config;

import com.siciliancodes.employeemanagement.entity.Department;
import com.siciliancodes.employeemanagement.entity.Employee;
import com.siciliancodes.employeemanagement.entity.Role;
import com.siciliancodes.employeemanagement.entity.User;
import com.siciliancodes.employeemanagement.repository.DepartmentRepository;
import com.siciliancodes.employeemanagement.repository.EmployeeRepository;
import com.siciliancodes.employeemanagement.repository.RoleRepository;
import com.siciliancodes.employeemanagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedData(
            DepartmentRepository departmentRepository,
            RoleRepository roleRepository,
            EmployeeRepository employeeRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {

        return args -> {

            // ---- DEPARTMENTS ----
            Department engineering = departmentRepository
                    .findByName("Engineering")
                    .orElseGet(() -> {
                        Department d = new Department();
                        d.setName("Engineering");
                        d.setCostCenter("ENG-100");
                        return departmentRepository.save(d);
                    });

            Department hr = departmentRepository
                    .findByName("Human Resources")
                    .orElseGet(() -> {
                        Department d = new Department();
                        d.setName("Human Resources");
                        d.setCostCenter("HR-200");
                        return departmentRepository.save(d);
                    });

            // ---- ROLES ----
            Role backendDev = roleRepository
                    .findByName("Backend Developer")
                    .orElseGet(() -> {
                        Role r = new Role();
                        r.setName("Backend Developer");
                        r.setDescription("Builds APIs and services");
                        return roleRepository.save(r);
                    });

            Role manager = roleRepository
                    .findByName("Manager")
                    .orElseGet(() -> {
                        Role r = new Role();
                        r.setName("Manager");
                        r.setDescription("Manages teams and projects");
                        return roleRepository.save(r);
                    });

            // ---- EMPLOYEES ----
            if (employeeRepository.findByEmail("john.doe@company.com").isEmpty()) {
                Employee emp1 = new Employee();
                emp1.setFirstName("John");
                emp1.setLastName("Doe");
                emp1.setEmail("john.doe@company.com");
                emp1.setDepartment(engineering);
                emp1.setRole(backendDev);
                employeeRepository.save(emp1);
            }

            if (employeeRepository.findByEmail("jane.smith@company.com").isEmpty()) {
                Employee emp2 = new Employee();
                emp2.setFirstName("Jane");
                emp2.setLastName("Smith");
                emp2.setEmail("jane.smith@company.com");
                emp2.setDepartment(hr);
                emp2.setRole(manager);
                employeeRepository.save(emp2);
            }

            // ---- USERS (AUTH) ----
            if (userRepository.findByEmail("admin@company.com").isEmpty()) {
                User admin = new User();
                admin.setEmail("admin@company.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole(User.Role.ADMIN);
                userRepository.save(admin);
            }

            if (userRepository.findByEmail("user@company.com").isEmpty()) {
                User user = new User();
                user.setEmail("user@company.com");
                user.setPassword(passwordEncoder.encode("user123"));
                user.setRole(User.Role.USER);
                userRepository.save(user);
            }
        };
    }
}


