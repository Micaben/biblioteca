package com.biblioteca.biblioteca.dto.mapper;

import com.biblioteca.biblioteca.dto.request.LibroRequest;
import com.biblioteca.biblioteca.dto.response.LibroResponse;
import com.biblioteca.biblioteca.entity.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public Libro toEntity(LibroRequest request){

        return Libro.builder()
                .titulo(request.getTitulo())
                .autor(request.getAutor())
                .isbn(request.getIsbn())
                .categoria(request.getCategoria())
                .stock(request.getStock())
                .estado(request.getEstado())
                .build();

    }

    public LibroResponse toResponse(Libro libro){

        return LibroResponse.builder()
                .id(libro.getId())
                .titulo(libro.getTitulo())
                .autor(libro.getAutor())
                .isbn(libro.getIsbn())
                .categoria(libro.getCategoria())
                .stock(libro.getStock())
                .estado(libro.getEstado())
                .build();

    }

}