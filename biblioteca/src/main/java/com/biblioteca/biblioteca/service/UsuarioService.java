package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.dto.request.UsuarioRequest;
import com.biblioteca.biblioteca.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();

    Optional<Usuario> buscarPorId(Long id);

    Usuario guardar(UsuarioRequest request);

    Usuario actualizar(Long id, UsuarioRequest request);

    void eliminar(Long id);
}