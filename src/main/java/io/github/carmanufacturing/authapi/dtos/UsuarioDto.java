package io.github.carmanufacturing.authapi.dtos;

import io.github.carmanufacturing.authapi.enums.RoleEnum;

public record UsuarioDto(
        String nome,
        String login,
        String senha,
        RoleEnum role
) {
}
