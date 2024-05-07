package io.carmanufacturing.strategy.newaccountImpl;

import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.dtos.UserPermissionsDto;
import io.carmanufacturing.persistence.UserEntity;
import io.carmanufacturing.respositories.UserRepository;
import io.carmanufacturing.strategy.NewAccountValidationStrategy;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ExistingCPFValidation  implements NewAccountValidationStrategy {

    @Autowired
    UserRepository userRepository;

    @SneakyThrows
    @Override
    public void execute(UserDto userDto, UserCredentialsDto userCredentialsDto, UserPermissionsDto userPermissionsDto) {
        UserEntity user = userRepository.findByCpf(userDto.cpf());
        if(Objects.isNull(user)){
            throw new Exception("Ja existe um usuario registrado com esse CPF");
        }
    }
}
