package io.carmanufacturing.servicesImpl;

import io.carmanufacturing.constants.CarManufacturingConstants;
import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.dtos.UserPermissionsDto;
import io.carmanufacturing.persistence.UserCredentialsPersistence;
import io.carmanufacturing.persistence.UserEntity;
import io.carmanufacturing.persistence.UserPermissionsEntity;
import io.carmanufacturing.respositories.UserCredentialsRepository;
import io.carmanufacturing.respositories.UserRepository;
import io.carmanufacturing.services.UserService;
import io.carmanufacturing.strategy.NewAccountValidationStrategy;
import io.carmanufacturing.utils.CarManufacturingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final List<NewAccountValidationStrategy> newAccountValidationStrategy;

    public UserServiceImpl(List<NewAccountValidationStrategy> newAccountValidationStrategy) {
        this.newAccountValidationStrategy = newAccountValidationStrategy;
    }


//    public ResponseEntity<String> salvar(Map<String, String> requestMap) {
//        UserCredentialsPersistence userCredentialsJaExiste = userCredentialsRepository.findByLogin(userCredentialsDto.login());
//        UserEntity userCpfAlreadyExists = userRepository.findByCpf(userDto.cpf());
//
//        if (userCredentialsJaExiste != null || userCpfAlreadyExists != null) {
//            throw new BusinessException("Usuário já existe!");
//        }
//
//        var passwordHash = passwordEncoder.encode(userCredentialsDto.senha());
//
//        UserCredentialsPersistence entity = new UserCredentialsPersistence(userCredentialsDto.login(), passwordHash);
//
//        UserCredentialsPersistence novoUserCredentials = userCredentialsRepository.save(entity);
//
//    }

    @Override
    public ResponseEntity<String> signUp(UserDto userDto, UserCredentialsDto userCredentialsDto, UserPermissionsDto userPermissionsDto) {
        newAccountValidationStrategy.forEach(validation -> validation.execute(userDto,userCredentialsDto,userPermissionsDto));

        try{

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CarManufacturingUtils.getResponseEntity(CarManufacturingConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

//    private boolean validateSignUpMap(Map<String, String> requestMap) {
//        if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
//                && requestMap.containsKey("email")
//                && requestMap.containsKey("password")) {
//            return true;
//        }
//        return false;
//    }

//    private UserEntity getUserFromMap(Map<String, String> requestMap) {
//        UserEntity user = new UserEntity();
//        UserPermissionsEntity userPermissions = new UserPermissionsEntity();
//        UserCredentialsPersistence userCredentials = new UserCredentialsPersistence();
//
//        userPermissions.setAssistant(true);
//        user.setName(requestMap.get("name"));
//        user.setCpf(requestMap.get("cpf"));
//        user.setBirth(requestMap.get("birth"));
//        user.setGender(requestMap.get("gender"));
//        user.setActiveUser(true);
//        userCredentials.setLogin(requestMap.get("login"));
//        userCredentials.setSenha(requestMap.get("password"));
//
//
//        return user;
//    }


}
