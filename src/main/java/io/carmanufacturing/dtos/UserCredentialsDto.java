package io.carmanufacturing.dtos;

import io.carmanufacturing.enums.RoleEnum;

public record UserCredentialsDto(
        String login,
        String senha
) {

}
