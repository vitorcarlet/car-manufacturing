package io.carmanufacturing.dtos;

import io.carmanufacturing.entities.UserPermissions;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



public record UserDto (
        String name,
        String cpf,
        Date birth,
        String gender,
        boolean activeUser


) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public String cpf() {
        return cpf;
    }

    @Override
    public Date birth() {
        return birth;
    }

    @Override
    public String gender() {
        return gender;
    }

    @Override
    public boolean activeUser() {
        return activeUser;
    }
}
