package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.biblioteca.biblioteca.enums.EstadoPrestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByUsuarioId(Long usuarioId);

    List<Prestamo> findByEstado(EstadoPrestamo estado);
}

