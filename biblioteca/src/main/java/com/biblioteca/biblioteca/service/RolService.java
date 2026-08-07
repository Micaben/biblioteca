package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.entity.Rol;
import com.biblioteca.biblioteca.enums.RolNombre;

import java.util.List;
import java.util.Optional;

public interface RolService {

    List<Rol> listar();

    Optional<Rol> buscarPorId(Long id);

    Optional<Rol> buscarPorNombre(RolNombre nombre);

    Rol guardar(Rol rol);

    void eliminar(Long id);

}