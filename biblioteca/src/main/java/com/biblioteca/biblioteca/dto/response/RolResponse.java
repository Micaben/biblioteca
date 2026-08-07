package com.biblioteca.biblioteca.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RolResponse {

    private Long id;

    private String nombre;

}