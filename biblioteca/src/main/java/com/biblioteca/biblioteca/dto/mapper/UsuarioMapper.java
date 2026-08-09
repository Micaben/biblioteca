package com.biblioteca.biblioteca.dto.mapper;

import com.biblioteca.biblioteca.dto.response.UsuarioResponse;
import com.biblioteca.biblioteca.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponse toResponse(Usuario usuario) {

        UsuarioResponse response = new UsuarioResponse();

        response.setId(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setCorreo(usuario.getCorreo());
        response.setEstado(usuario.getEstado());
        response.setUsername(usuario.getUsername());

        if (usuario.getRol() != null) {
            response.setRolId(usuario.getRol().getId());
        }

        return response;
    }
}