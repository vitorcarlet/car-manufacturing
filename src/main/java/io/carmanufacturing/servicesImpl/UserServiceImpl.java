package io.carmanufacturing.servicesImpl;

import io.carmanufacturing.constants.CarManufacturingConstants;
import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.dtos.UserPermissionsDto;
import io.carmanufacturing.persistence.UserCredentialsEntity;
import io.carmanufacturing.persistence.UserEntity;
import io.carmanufacturing.persistence.UserPermissionsEntity;
import io.carmanufacturing.respositories.UserCredentialsRepository;
import io.carmanufacturing.respositories.UserPermissionsRepository;
import io.carmanufacturing.respositories.UserRepository;
import io.carmanufacturing.services.UserService;
import io.carmanufacturing.strategy.NewAccountValidationStrategy;
import io.carmanufacturing.utils.CarManufacturingUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPermissionsRepository userPermissionsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final List<NewAccountValidationStrategy> newAccountValidationStrategy;

    public UserServiceImpl(List<NewAccountValidationStrategy> newAccountValidationStrategy) {
        this.newAccountValidationStrategy = newAccountValidationStrategy;
    }




    @Override
    public ResponseEntity<String> signUp(UserDto userDto, UserCredentialsDto userCredentialsDto, UserPermissionsDto userPermissionsDto) {
        //newAccountValidationStrategy.forEach(validation -> validation.execute(userDto,userCredentialsDto,userPermissionsDto));

        if (Objects.isNull(userPermissionsDto)) {
            // Handle null values appropriately, e.g., set defaults or reject the request
            return ResponseEntity.badRequest().body("UserPermissionsDto must not contain null values");
        }


        log.info("chegou no signup");
        log.info(userPermissionsDto.toString());
        log.info(userCredentialsDto.toString());
        log.info(userDto.toString());
        try{

            var passwordHash = passwordEncoder.encode(userCredentialsDto.password());

            UserEntity user = new UserEntity(userDto.name(),userDto.cpf(), userDto.birth() ,userDto.gender(),true);
             UserCredentialsEntity userCredentials = new UserCredentialsEntity(userCredentialsDto.login(),passwordHash,user);
            UserPermissionsEntity userPermissions = new UserPermissionsEntity(userPermissionsDto.isAdmin(), userPermissionsDto.isOperator(),userPermissionsDto.isAssistant(), userCredentials);
            userRepository.save(user);
            userCredentialsRepository.save(userCredentials);
            userPermissionsRepository.save(userPermissions);

            return CarManufacturingUtils.getResponseEntity("Succesfully Registered",HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }




}
