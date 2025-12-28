package com.siciliancodes.employeemanagement.repository;

import com.siciliancodes.employeemanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    Optional<Department> findByName(String name);

    Optional<Department> findByCostCenter(Integer costCenter);
}
