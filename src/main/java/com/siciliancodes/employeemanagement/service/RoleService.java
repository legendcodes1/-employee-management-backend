package com.siciliancodes.employeemanagement.service;

import com.siciliancodes.employeemanagement.entity.Role;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {

    List<Role> getAllRoles();

    Optional<Role> getRoleById(UUID id);

    Optional<Role> getRoleByName(String name);

    Role createRole(Role role);

    Role updateRole(UUID id, Role role);

    void deleteRole(UUID id);
}