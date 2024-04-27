package io.github.carmanufacturing.authapi.controllers;

import io.github.carmanufacturing.authapi.services.UsuarioService;
import io.github.carmanufacturing.authapi.dtos.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto) {
        return  usuarioService.salvar(usuarioDto) ;
    }

    @GetMapping("/admin")
    private String getAdmin() {
        return "permissão de administrador";
    }

    @GetMapping("/user")
    private String getUser() {
        return "permissão de usuário";
    }
}
