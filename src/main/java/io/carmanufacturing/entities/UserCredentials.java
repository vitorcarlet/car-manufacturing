package io.carmanufacturing.entities;

import io.carmanufacturing.enums.RoleEnum;

public record UserCredentials(
        Long id,
        String nome,
        String login,
        String senha,
        RoleEnum role,
        User userId
        ) {
}
