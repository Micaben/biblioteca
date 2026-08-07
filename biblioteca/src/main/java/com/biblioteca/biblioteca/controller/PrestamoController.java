package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.entity.Prestamo;
import com.biblioteca.biblioteca.service.PrestamoService;
import org.springframework.web.bind.annotation.*;
import com.biblioteca.biblioteca.dto.request.PrestamoRequest;
import java.util.List;
import java.util.Optional;
import com.biblioteca.biblioteca.dto.mapper.PrestamoMapper;
import com.biblioteca.biblioteca.dto.response.PrestamoResponse;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;
    private final PrestamoMapper prestamoMapper;

    public PrestamoController(
            PrestamoService prestamoService,
            PrestamoMapper prestamoMapper) {

        this.prestamoService = prestamoService;
        this.prestamoMapper = prestamoMapper;
    }

    @GetMapping
    public List<PrestamoResponse> listar(){

        return prestamoService.listar()
                .stream()
                .map(prestamoMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public PrestamoResponse buscar(@PathVariable Long id){

        Prestamo prestamo = prestamoService.buscarPorId(id)
                .orElseThrow(() ->
                        new RuntimeException("Préstamo no encontrado"));

        return prestamoMapper.toResponse(prestamo);
    }

    @PostMapping
    public PrestamoResponse registrar(
            @RequestBody PrestamoRequest request){

        return prestamoMapper.toResponse(
                prestamoService.registrarPrestamo(request));

    }

    @PutMapping("/{id}")
    public Prestamo actualizar(@PathVariable Long id,
                               @RequestBody Prestamo prestamo) {
        return prestamoService.actualizar(id, prestamo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        prestamoService.eliminar(id);
    }

    @PutMapping("/{id}/devolver")
    public Prestamo devolver(@PathVariable Long id) {
        return prestamoService.devolver(id);
    }
}