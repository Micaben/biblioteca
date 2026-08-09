package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.dto.mapper.UsuarioMapper;
import com.biblioteca.biblioteca.dto.request.UsuarioRequest;
import com.biblioteca.biblioteca.dto.response.UsuarioResponse;
import com.biblioteca.biblioteca.entity.Usuario;
import com.biblioteca.biblioteca.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(
            UsuarioService usuarioService,
            UsuarioMapper usuarioMapper) {

        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @GetMapping
    public List<UsuarioResponse> listar() {

        return usuarioService.listar()
                .stream()
                .map(usuarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UsuarioResponse buscarPorId(@PathVariable Long id) {

        Usuario usuario = usuarioService.buscarPorId(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado"));

        return usuarioMapper.toResponse(usuario);
    }

    @PostMapping
    public UsuarioResponse registrar(
            @Valid @RequestBody UsuarioRequest request) {

        return usuarioMapper.toResponse(
                usuarioService.guardar(request)
        );
    }

    @PutMapping("/{id}")
    public UsuarioResponse actualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequest request) {

        return usuarioMapper.toResponse(
                usuarioService.actualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}