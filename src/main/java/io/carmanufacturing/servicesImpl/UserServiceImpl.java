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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserCredentialsDto salvar(UserCredentialsDto userCredentialsDto, UserDto userDto) {
        UserCredentialsPersistence userCredentialsJaExiste = userCredentialsRepository.findByLogin(userCredentialsDto.login());
        UserEntity userCpfAlreadyExists = userRepository.findByCpf(userDto.cpf());

        if (userCredentialsJaExiste != null || userCpfAlreadyExists != null) {
            throw new BusinessException("Usuário já existe!");
        }

        var passwordHash = passwordEncoder.encode(userCredentialsDto.senha());

        UserCredentialsPersistence entity = new UserCredentialsPersistence(userCredentialsDto.nome(), userCredentialsDto.login(), passwordHash, userCredentialsDto.role());

        UserCredentialsPersistence novoUserCredentials = userCredentialsRepository.save(entity);

        return new UserCredentialsDto(novoUserCredentials.getNome(), novoUserCredentials.getLogin(), novoUserCredentials.getSenha(), novoUserCredentials.getRole());
    }
}
