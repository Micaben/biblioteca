package com.biblioteca.biblioteca.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponse {

    private String token;

    private String type = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }

}