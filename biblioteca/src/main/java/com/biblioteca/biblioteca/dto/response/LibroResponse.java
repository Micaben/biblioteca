package com.biblioteca.biblioteca.dto.response;

import com.biblioteca.biblioteca.enums.EstadoLibro;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LibroResponse {

    private Long id;

    private String titulo;

    private String autor;

    private String isbn;

    private String categoria;

    private Integer stock;

    private EstadoLibro estado;

}