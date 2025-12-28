package com.siciliancodes.employeemanagement.dto;
import lombok.*;

@Getter @Setter
public class LoginRequest {
    private String email;
    private String password;
}
