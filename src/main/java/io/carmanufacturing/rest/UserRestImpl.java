package io.carmanufacturing.rest;

import io.carmanufacturing.constants.CarManufacturingConstants;
import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.dtos.UserPermissionsDto;
import io.carmanufacturing.services.UserService;
import io.carmanufacturing.utils.CarManufacturingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UserRestImpl {

    @Autowired
    UserService userService;

    @PostMapping
    ResponseEntity<String> signUp(@RequestBody UserDto userDto, UserCredentialsDto userCredentialsDto, UserPermissionsDto userPermissionsDto){
        try{
            return userService.signUp(userDto,userCredentialsDto,userPermissionsDto);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "yes";
    }

    @GetMapping("/user")
    public String getUser() {
        return "yes";
    }

}
