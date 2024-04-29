package io.carmanufacturing.usecasesImpl;

import io.carmanufacturing.entities.User;
import io.carmanufacturing.gateways.UserGateway;
import io.carmanufacturing.usecases.GetAllUsersUseCase;

import java.util.List;

public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {

    private final UserGateway userGateway;

    public GetAllUsersUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<User> execute() {
        return userGateway.obtainAllUsers();
    }
}
