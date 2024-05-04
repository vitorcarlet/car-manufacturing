package io.carmanufacturing.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public record UserCredentialsDto(
        String login,
        String password
) {

}
