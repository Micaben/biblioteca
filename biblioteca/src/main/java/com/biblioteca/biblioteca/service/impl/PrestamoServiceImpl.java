package com.biblioteca.biblioteca.service.impl;

import com.biblioteca.biblioteca.entity.Prestamo;
import com.biblioteca.biblioteca.repository.PrestamoRepository;
import com.biblioteca.biblioteca.service.PrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.biblioteca.biblioteca.entity.Libro;
import com.biblioteca.biblioteca.entity.Usuario;
import com.biblioteca.biblioteca.enums.EstadoLibro;
import com.biblioteca.biblioteca.enums.EstadoPrestamo;
import com.biblioteca.biblioteca.repository.LibroRepository;
import com.biblioteca.biblioteca.repository.UsuarioRepository;

import java.time.LocalDate;
import com.biblioteca.biblioteca.dto.request.PrestamoRequest;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LibroRepository libroRepository;

    public PrestamoServiceImpl(
            PrestamoRepository prestamoRepository,
            UsuarioRepository usuarioRepository,
            LibroRepository libroRepository) {

        this.prestamoRepository = prestamoRepository;
        this.usuarioRepository = usuarioRepository;
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Prestamo> listar() {
        return prestamoRepository.findAll();
    }

    @Override
    public Optional<Prestamo> buscarPorId(Long id) {
        return prestamoRepository.findById(id);
    }

    @Override
    public Prestamo guardar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo actualizar(Long id, Prestamo prestamo) {

        Prestamo actual = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        actual.setFechaPrestamo(prestamo.getFechaPrestamo());
        actual.setFechaDevolucion(prestamo.getFechaDevolucion());
        actual.setEstado(prestamo.getEstado());
        actual.setUsuario(prestamo.getUsuario());
        actual.setLibro(prestamo.getLibro());

        return prestamoRepository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        prestamoRepository.deleteById(id);
    }

    @Transactional
    public Prestamo registrarPrestamo(Long usuarioId, Long libroId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado"));

        Libro libro = libroRepository.buscarParaPrestamo(libroId)
                .orElseThrow(() ->
                        new RuntimeException("Libro no encontrado"));

        if (libro.getStock() <= 0) {
            throw new RuntimeException("No hay stock disponible");
        }

        libro.setStock(libro.getStock() - 1);

        if (libro.getStock() == 0) {
            libro.setEstado(EstadoLibro.PRESTADO);
        }

        libroRepository.save(libro);

        Prestamo prestamo = Prestamo.builder()
                .usuario(usuario)
                .libro(libro)
                .fechaPrestamo(LocalDate.now())
                .estado(EstadoPrestamo.ACTIVO)
                .build();

        return prestamoRepository.save(prestamo);
    }

    @Transactional
    @Override
    public Prestamo registrarPrestamo(PrestamoRequest request) {

        return registrarPrestamo(
                request.getUsuarioId(),
                request.getLibroId()
        );

    }

    @Transactional
    @Override
    public Prestamo devolver(Long id) {

        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        if (prestamo.getEstado() == EstadoPrestamo.DEVUELTO) {
            throw new RuntimeException("El préstamo ya fue devuelto");
        }

        Libro libro = prestamo.getLibro();

        libro.setStock(libro.getStock() + 1);
        libro.setEstado(EstadoLibro.DISPONIBLE);

        libroRepository.save(libro);

        prestamo.setEstado(EstadoPrestamo.DEVUELTO);
        prestamo.setFechaDevolucion(LocalDate.now());

        return prestamoRepository.save(prestamo);
    }
}