package io.carmanufacturing.usecases;

import io.carmanufacturing.entities.User;

public interface CreateUserUseCase {
    public User execute(User user);
}
