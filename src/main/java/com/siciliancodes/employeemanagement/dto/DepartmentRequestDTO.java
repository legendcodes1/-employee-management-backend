package com.siciliancodes.employeemanagement.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DepartmentRequestDTO {

    // getters & setters
    @NotBlank(message = "Department name is required")
    private String name;


    @Column(nullable = false)
    private String costCenter; // not Integer


    public void setName(String name) {
        this.name = name;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }
}
