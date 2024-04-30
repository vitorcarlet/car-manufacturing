package io.carmanufacturing.controllers;

import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.rest.UserCredentialsRest;
import io.carmanufacturing.services.UserService;
import io.carmanufacturing.dtos.UserCredentialsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserCredentialsController implements UserCredentialsRest {

    @Autowired
    private UserService userService;

    @Override
    public UserCredentialsDto salvar(@RequestBody UserCredentialsDto userCredentialsDto, UserDto userDto) {
        return  userService.salvar(userCredentialsDto,userDto) ;
    }

    @Override
    public String getAdmin() {
        return "permissão de administrador";
    }

    @Override
    public String getUser() {
        return "permissão de usuário";
    }
}
