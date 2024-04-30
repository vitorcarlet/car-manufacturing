package io.carmanufacturing.services;

import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.entities.User;

public interface UserService {

    public UserCredentialsDto salvar(UserCredentialsDto userCredentialsDto, UserDto userDto);
}
