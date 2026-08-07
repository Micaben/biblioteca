package com.biblioteca.biblioteca.dto.mapper;

import com.biblioteca.biblioteca.dto.response.PrestamoResponse;
import com.biblioteca.biblioteca.entity.Prestamo;
import org.springframework.stereotype.Component;

@Component
public class PrestamoMapper {

    public PrestamoResponse toResponse(Prestamo prestamo){

        return PrestamoResponse.builder()
                .id(prestamo.getId())
                .usuario(prestamo.getUsuario().getNombre())
                .libro(prestamo.getLibro().getTitulo())
                .fechaPrestamo(prestamo.getFechaPrestamo())
                .fechaDevolucion(prestamo.getFechaDevolucion())
                .estado(prestamo.getEstado())
                .build();

    }

}