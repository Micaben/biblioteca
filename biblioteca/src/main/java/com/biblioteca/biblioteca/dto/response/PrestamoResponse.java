package com.biblioteca.biblioteca.dto.response;

import com.biblioteca.biblioteca.enums.EstadoPrestamo;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrestamoResponse {

    private Long id;

    private String usuario;

    private String libro;

    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucion;

    private EstadoPrestamo estado;
}