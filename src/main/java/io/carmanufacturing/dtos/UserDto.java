package io.carmanufacturing.dtos;

import io.carmanufacturing.entities.UserPermissions;
import io.carmanufacturing.persistence.UserCredentialsPersistence;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public record UserDto (
        String name,
        String cpf,
        Date birth,
        String gender,
        boolean activeUser,

        UserPermissions userPermissions
//        UserCredentialsPersistence userCredentials,
//        UserPermissions userPermissions
) {}
