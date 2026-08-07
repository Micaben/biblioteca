package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.entity.Libro;
import com.biblioteca.biblioteca.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> listar() {
        return libroService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Libro> buscarPorId(@PathVariable Long id) {
        return libroService.buscarPorId(id);
    }

    @PostMapping
    public Libro guardar(@RequestBody Libro libro) {
        return libroService.guardar(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id,
                            @RequestBody Libro libro) {

        return libroService.actualizar(id, libro);

    }
}