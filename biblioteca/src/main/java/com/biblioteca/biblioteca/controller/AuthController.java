package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.security.dto.JwtResponse;
import com.biblioteca.biblioteca.security.dto.LoginRequest;
import com.biblioteca.biblioteca.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request){

        return authService.login(request);

    }

}