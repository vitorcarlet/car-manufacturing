package io.carmanufacturing.controllers;

import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public UserDto toDto(User user){
        return new UserDto(user.name(), user.cpf(), user.birth(),user.gender(),user.activeUser(),user.userCredentials(),user.userPermissions());
    }

    public User toDomain(UserDto userDto){
        return new User(null, userDto.name(), userDto.cpf(), userDto.birth(), userDto.gender(), userDto.activeUser(),userDto.userCredentials(),userDto.userPermissions());
    }

}
