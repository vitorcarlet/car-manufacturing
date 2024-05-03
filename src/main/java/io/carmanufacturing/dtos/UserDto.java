package io.carmanufacturing.dtos;

import io.carmanufacturing.entities.UserPermissions;
import io.carmanufacturing.persistence.UserCredentialsPersistence;

import java.util.Date;

public record UserDto (
        String name,
        String cpf,
        Date birth,
        String gender,
        boolean activeUser
//        UserCredentialsPersistence userCredentials,
//        UserPermissions userPermissions
) {}
