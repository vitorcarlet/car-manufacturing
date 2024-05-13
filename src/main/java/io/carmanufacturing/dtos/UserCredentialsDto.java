package io.carmanufacturing.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;



public record UserCredentialsDto(
        String login,
        String password
) {
    @Override
    public String login() {
        return password;
    }

    @Override
    public String password() {
        return password;
    }
}
