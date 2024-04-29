package io.carmanufacturing.controllers;

import io.carmanufacturing.rest.AuthControllerRest;
import io.carmanufacturing.services.AuthService;
import io.carmanufacturing.dtos.AuthDto;
import io.carmanufacturing.dtos.RequestRefreshDto;
import io.carmanufacturing.dtos.TokenResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController

public class AuthController implements AuthControllerRest {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Override
    public TokenResponseDto auth(@RequestBody AuthDto authDto) {

        var usuarioAutenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.senha());

        authenticationManager.authenticate(usuarioAutenticationToken);

        return authService.obterToken(authDto);
    }

    @Override
    public TokenResponseDto authRefreshToken(@RequestBody RequestRefreshDto requestRefreshDto) {
        return authService.obterRefreshToken(requestRefreshDto.refreshToken());
    }
}
