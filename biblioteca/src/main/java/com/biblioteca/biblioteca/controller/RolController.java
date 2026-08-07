package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.dto.mapper.RolMapper;
import com.biblioteca.biblioteca.dto.response.RolResponse;
import com.biblioteca.biblioteca.service.RolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<RolResponse> listar() {

        return rolService.listar()
                .stream()
                .map(RolMapper::toResponse)
                .toList();

    }

}