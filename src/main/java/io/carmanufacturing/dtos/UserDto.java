package io.carmanufacturing.dtos;

import io.carmanufacturing.entities.UserCredentials;
import io.carmanufacturing.entities.UserPermissions;

import java.util.Date;

public record UserDto (
        String name,
        String cpf,
        Date birth,
        String gender,
        boolean activeUser,
        UserCredentials userCredentials,
        UserPermissions userPermissions
) {}
