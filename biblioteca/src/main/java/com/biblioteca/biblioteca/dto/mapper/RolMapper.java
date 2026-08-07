package com.biblioteca.biblioteca.dto.mapper;

import com.biblioteca.biblioteca.dto.response.RolResponse;
import com.biblioteca.biblioteca.entity.Rol;

public class RolMapper {

    private RolMapper() {
    }

    public static RolResponse toResponse(Rol rol) {

        return RolResponse.builder()
                .id(rol.getId())
                .nombre(rol.getNombre().name())
                .build();

    }

}