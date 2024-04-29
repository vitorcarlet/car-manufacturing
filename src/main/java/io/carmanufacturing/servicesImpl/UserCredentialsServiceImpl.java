package io.carmanufacturing.servicesImpl;

import io.carmanufacturing.dtos.UserCredentialsDto;
import io.carmanufacturing.entities.UserCredentials;
import io.carmanufacturing.A1Infrastructure.exceptions.BusinessException;
import io.carmanufacturing.respositories.UsuarioRepository;
import io.carmanufacturing.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserCredentialsDto salvar(UserCredentialsDto userCredentialsDto) {

        UserCredentials userCredentialsJaExiste = usuarioRepository.findByLogin(userCredentialsDto.login());

        if (userCredentialsJaExiste != null) {
            throw new BusinessException("Usuário já existe!");
        }

        var passwordHash = passwordEncoder.encode(userCredentialsDto.senha());

        UserCredentials entity = new UserCredentials(userCredentialsDto.nome(), userCredentialsDto.login(), passwordHash, userCredentialsDto.role());

        UserCredentials novoUserCredentials = usuarioRepository.save(entity);

        return new UserCredentialsDto(novoUserCredentials.getNome(), novoUserCredentials.getLogin(), novoUserCredentials.getSenha(), novoUserCredentials.getRole());
    }
}
