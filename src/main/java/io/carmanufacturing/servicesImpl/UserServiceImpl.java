package io.carmanufacturing.servicesImpl;

import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.dtos.UserDto;
import io.carmanufacturing.A1Infrastructure.exceptions.BusinessException;
import io.carmanufacturing.persistence.UserCredentialsPersistence;
import io.carmanufacturing.persistence.UserEntity;
import io.carmanufacturing.respositories.UserCredentialsRepository;
import io.carmanufacturing.respositories.UserRepository;
import io.carmanufacturing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


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
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        return null;
    }
}
