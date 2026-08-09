package com.biblioteca.biblioteca.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String correo;
    private Boolean estado;
    private String username;
    private Long rolId;
}