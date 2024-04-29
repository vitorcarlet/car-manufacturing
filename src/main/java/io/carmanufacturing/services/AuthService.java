package io.carmanufacturing.services;

import io.carmanufacturing.dtos.AuthDto;
import io.carmanufacturing.dtos.TokenResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    public TokenResponseDto obterToken(AuthDto authDto);
    public String validaTokenJwt(String token);

    TokenResponseDto obterRefreshToken(String s);
}
