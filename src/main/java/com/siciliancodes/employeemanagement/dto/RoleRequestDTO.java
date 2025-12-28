package com.siciliancodes.employeemanagement.dto;

import jakarta.validation.constraints.NotBlank;

public class RoleRequestDTO {

    @NotBlank(message = "Role name is required")
    private String name;

    private String description;

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
