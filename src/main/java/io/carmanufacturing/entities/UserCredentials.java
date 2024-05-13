package io.carmanufacturing.entities;

import io.carmanufacturing.enums.RoleEnum;

public record UserCredentials(
        Long id,
        String login,
        String password,
        User userId
        ) {
}
