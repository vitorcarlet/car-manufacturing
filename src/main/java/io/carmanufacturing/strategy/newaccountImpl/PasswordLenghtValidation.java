package io.carmanufacturing.strategy.newaccountImpl;

import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.dtos.UserPermissionsDto;
import io.carmanufacturing.strategy.NewAccountValidationStrategy;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class PasswordLenghtValidation implements NewAccountValidationStrategy {

    @SneakyThrows
    @Override
    public void execute(UserDto userDto, UserCredentialsDto userCredentialsDto, UserPermissionsDto userPermissionsDto) {
        if(userCredentialsDto.getPassword().length() < 8 || userCredentialsDto.getPassword().length() > 12) {
            throw new Exception("A senha deve ter no mínimo 8 caracteres e no máximo 12 caracteres.");
        }
    }




}
