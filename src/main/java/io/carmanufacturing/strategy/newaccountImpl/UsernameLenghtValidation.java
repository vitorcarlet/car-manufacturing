package io.carmanufacturing.strategy.newaccountImpl;

import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.dtos.UserPermissionsDto;
import io.carmanufacturing.strategy.NewAccountValidationStrategy;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class UsernameLenghtValidation implements NewAccountValidationStrategy {

    @SneakyThrows
    @Override
    public void execute(UserDto userDto, UserCredentialsDto userCredentialsDto, UserPermissionsDto userPermissionsDto) {
        if(!userDto.getName().matches("^[a-zA-Z]+$")){
            throw new Exception("O nome deve conter apenas letras.");
        }
    }
}
