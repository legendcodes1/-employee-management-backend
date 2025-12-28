package com.siciliancodes.employeemanagement.dto;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String role;
}
