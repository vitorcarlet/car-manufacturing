package io.carmanufacturing.rest;

import io.carmanufacturing.dtos.UserCredentialsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/usuarios")
public interface UserCredentialsRest {

    @PostMapping
     UserCredentialsDto salvar(@RequestBody UserCredentialsDto userCredentialsDto);

    @GetMapping("/admin")
     String getAdmin();

    @GetMapping("/user")
     String getUser();

}
