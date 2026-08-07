package com.biblioteca.biblioteca.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestamoRequest {

    private Long usuarioId;

    private Long libroId;

}