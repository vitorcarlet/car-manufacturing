package io.carmanufacturing.usecases;

import io.carmanufacturing.entities.User;

import java.util.List;

public interface GetAllUsersUseCase {
    public List<User> execute();
}
