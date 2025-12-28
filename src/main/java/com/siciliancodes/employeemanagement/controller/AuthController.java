package com.siciliancodes.employeemanagement.controller;

import com.siciliancodes.employeemanagement.dto.AuthResponse;
import com.siciliancodes.employeemanagement.dto.LoginRequest;
import com.siciliancodes.employeemanagement.service.AuthService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173") // Vite
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
