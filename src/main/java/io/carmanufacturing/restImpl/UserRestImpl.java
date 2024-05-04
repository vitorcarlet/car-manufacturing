package io.carmanufacturing.restImpl;

import io.carmanufacturing.constants.CarManufacturingConstants;
import io.carmanufacturing.rest.UserRest;
import io.carmanufacturing.services.UserService;
import io.carmanufacturing.utils.CarManufacturingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> registrar(Map<String, String> requestMap) {
        try{
            return userService.signUp(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public String getAdmin() {
        return "yes";
    }

    @Override
    public String getUser() {
        return "yes";
    }
}
