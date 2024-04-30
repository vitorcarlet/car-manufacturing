package io.carmanufacturing.rest;

import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/usuarios")
public interface UserCredentialsRest {

    @PostMapping
     UserCredentialsDto salvar(@RequestBody UserCredentialsDto userCredentialsDto, UserDto userDto);

    @GetMapping("/admin")
     String getAdmin();

    @GetMapping("/user")
     String getUser();

}
