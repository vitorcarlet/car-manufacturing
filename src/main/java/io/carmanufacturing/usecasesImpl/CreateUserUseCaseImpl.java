package io.carmanufacturing.usecasesImpl;

import io.carmanufacturing.entities.User;
import io.carmanufacturing.gateways.UserGateway;
import io.carmanufacturing.A1Infrastructure.exceptions.BusinessException;
import io.carmanufacturing.usecases.CreateUserUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        User userExist = userGateway.findByCpf(user.cpf());
        if(userExist != null) {
            throw new BusinessException("Já existe uma pessoa com CPF "+user.cpf() + " cadastrado!");
        }
        return userGateway.createUser(user);
    }
}
