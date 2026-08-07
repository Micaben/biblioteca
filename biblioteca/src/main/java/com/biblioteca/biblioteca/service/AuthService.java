package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.security.dto.JwtResponse;
import com.biblioteca.biblioteca.security.dto.LoginRequest;

public interface AuthService {

    JwtResponse login(LoginRequest request);

}