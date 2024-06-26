package io.carmanufacturing.services;

import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.dtos.UserPermissionsDto;
import io.carmanufacturing.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface UserService {


    public ResponseEntity<String> signUp(@RequestBody(required = true) UserDto userDto, UserCredentialsDto userCredentialsDto, UserPermissionsDto userPermissionsDto);
}
