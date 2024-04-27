package io.github.carmanufacturing.authapi.services.impl;

import io.github.carmanufacturing.authapi.infra.exceptions.BusinessException;
import io.github.carmanufacturing.authapi.models.Usuario;
import io.github.carmanufacturing.authapi.respositories.UsuarioRepository;
import io.github.carmanufacturing.authapi.services.UsuarioService;
import io.github.carmanufacturing.authapi.dtos.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto salvar(UsuarioDto usuarioDto) {

        Usuario usuarioJaExiste = usuarioRepository.findByLogin(usuarioDto.login());

        if (usuarioJaExiste != null) {
            throw new BusinessException("Usuário já existe!");
        }

        var passwordHash = passwordEncoder.encode(usuarioDto.senha());

        Usuario entity = new Usuario(usuarioDto.nome(), usuarioDto.login(), passwordHash, usuarioDto.role());

        Usuario novoUsuario = usuarioRepository.save(entity);

        return new UsuarioDto(novoUsuario.getNome(), novoUsuario.getLogin(), novoUsuario.getSenha(), novoUsuario.getRole());
    }
}
