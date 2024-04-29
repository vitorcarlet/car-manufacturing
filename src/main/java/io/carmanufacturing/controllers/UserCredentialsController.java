package io.carmanufacturing.controllers;

import io.carmanufacturing.rest.UserCredentialsRest;
import io.carmanufacturing.services.UsuarioService;
import io.carmanufacturing.dtos.UserCredentialsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserCredentialsController implements UserCredentialsRest {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserCredentialsDto salvar(@RequestBody UserCredentialsDto userCredentialsDto) {
        return  usuarioService.salvar(userCredentialsDto) ;
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
