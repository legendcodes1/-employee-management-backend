package com.siciliancodes.employeemanagement.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String status;

    private String departmentName;
    private String roleName;
}
