package com.biblioteca.biblioteca.service.impl;

import com.biblioteca.biblioteca.entity.Rol;
import com.biblioteca.biblioteca.enums.RolNombre;
import com.biblioteca.biblioteca.repository.RolRepository;
import com.biblioteca.biblioteca.service.RolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository repository;

    public RolServiceImpl(RolRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Rol> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Rol> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Rol> buscarPorNombre(RolNombre nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public Rol guardar(Rol rol) {
        return repository.save(rol);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}