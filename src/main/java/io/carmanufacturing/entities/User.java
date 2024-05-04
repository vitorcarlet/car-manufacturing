package io.carmanufacturing.entities;

import io.carmanufacturing.persistence.UserCredentialsPersistence;

import java.util.Date;

public record User(Long id,
                   String name,
                   String cpf,
                   Date birth,
                   String gender,
                   boolean activeUser,
//                   UserCredentialsPersistence userCredentials,
//
                   UserPermissions userPermissions
                   ) {}
