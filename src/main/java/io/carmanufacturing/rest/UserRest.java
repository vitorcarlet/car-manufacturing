package io.carmanufacturing.rest;

import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.dtos.UserPermissionsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/usuarios")
public interface UserRest {

    @PostMapping
    ResponseEntity<String> registrar(@RequestBody UserDto userDto, UserCredentialsDto userCredentialsDto, UserPermissionsDto userPermissionsDto);

    @GetMapping("/admin")
     String getAdmin();

    @GetMapping("/user")
     String getUser();

}
