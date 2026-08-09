package com.biblioteca.biblioteca.service.impl;

import com.biblioteca.biblioteca.dto.request.UsuarioRequest;
import com.biblioteca.biblioteca.entity.Rol;
import com.biblioteca.biblioteca.entity.Usuario;
import com.biblioteca.biblioteca.repository.RolRepository;
import com.biblioteca.biblioteca.repository.UsuarioRepository;
import com.biblioteca.biblioteca.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepository,
            RolRepository rolRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardar(UsuarioRequest request) {

        Rol rol = rolRepository.findById(request.getRolId())
                .orElseThrow(() ->
                        new RuntimeException("Rol no encontrado"));

        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre());
        usuario.setCorreo(request.getCorreo());

        usuario.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        usuario.setRol(rol);
        usuario.setEstado(true);

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Long id, UsuarioRequest request) {

        Usuario actual = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepository.findById(request.getRolId())
                .orElseThrow(() ->
                        new RuntimeException("Rol no encontrado"));

        actual.setNombre(request.getNombre());
        actual.setCorreo(request.getCorreo());

        actual.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        actual.setRol(rol);

        return usuarioRepository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}