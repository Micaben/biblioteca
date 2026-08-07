package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.entity.Prestamo;
import com.biblioteca.biblioteca.dto.request.PrestamoRequest;
import java.util.List;
import java.util.Optional;

public interface PrestamoService {

    List<Prestamo> listar();

    Optional<Prestamo> buscarPorId(Long id);

    Prestamo guardar(Prestamo prestamo);

    Prestamo actualizar(Long id, Prestamo prestamo);

    void eliminar(Long id);

    Prestamo devolver(Long id);

    Prestamo registrarPrestamo(PrestamoRequest request);
}