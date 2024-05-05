package io.carmanufacturing.dtos;

import io.carmanufacturing.entities.UserPermissions;
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
//        UserCredentialsEntity userCredentials,
//        UserPermissions userPermissions
) {}
