package com.biblioteca.biblioteca.service.impl;

import com.biblioteca.biblioteca.entity.Libro;
import com.biblioteca.biblioteca.repository.LibroRepository;
import com.biblioteca.biblioteca.service.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> buscarPorId(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public Libro actualizar(Long id, Libro libro) {

        Libro libroActual = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        libroActual.setTitulo(libro.getTitulo());
        libroActual.setAutor(libro.getAutor());
        libroActual.setIsbn(libro.getIsbn());
        libroActual.setCategoria(libro.getCategoria());
        libroActual.setStock(libro.getStock());
        libroActual.setEstado(libro.getEstado());

        return libroRepository.save(libroActual);
    }
}