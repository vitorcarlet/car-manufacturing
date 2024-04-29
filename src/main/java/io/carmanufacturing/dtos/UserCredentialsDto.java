package io.carmanufacturing.dtos;

import io.carmanufacturing.enums.RoleEnum;

public record UserCredentialsDto(
        String nome,
        String login,
        String senha,
        RoleEnum role
) {
}
