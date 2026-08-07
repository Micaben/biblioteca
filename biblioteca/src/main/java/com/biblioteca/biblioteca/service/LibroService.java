package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.entity.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {

    List<Libro> listar();

    Optional<Libro> buscarPorId(Long id);

    Libro guardar(Libro libro);

    Libro actualizar(Long id, Libro libro);

    void eliminar(Long id);

}