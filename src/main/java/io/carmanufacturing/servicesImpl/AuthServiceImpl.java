package io.carmanufacturing.servicesImpl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.carmanufacturing.dtos.AuthDto;
import io.carmanufacturing.dtos.TokenResponseDto;
import io.carmanufacturing.entities.UserCredentials;
import io.carmanufacturing.A1Infrastructure.exceptions.UnauthorizedException;
import io.carmanufacturing.respositories.UsuarioRepository;
import io.carmanufacturing.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${auth.jwt.token.secret}")
    private String secretKey;

    @Value("${auth.jwt.token.expiration}")
    private Integer horaExpiracaoToken;

    @Value("${auth.jwt.refresh-token.expiration}")
    private Integer horaExpiracaoRefreshToken ;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login);
    }

    @Override
    public TokenResponseDto obterToken(AuthDto authDto) {
        UserCredentials userCredentials = usuarioRepository.findByLogin(authDto.login());

        return TokenResponseDto
                .builder()
                .token(geraTokenJwt(userCredentials,horaExpiracaoToken))
                .refreshToken(geraTokenJwt(userCredentials,horaExpiracaoRefreshToken))
                .build();
    }

    public  String geraTokenJwt(UserCredentials userCredentials, Integer expiration) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            
            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(userCredentials.getLogin())
                    .withExpiresAt(geraDataExpiracao(expiration))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao tentar gerar o token! " +exception.getMessage());
        }
    }

    public String validaTokenJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    @Override
    public TokenResponseDto obterRefreshToken(String refreshToken) {

        String login = validaTokenJwt(refreshToken);
        UserCredentials userCredentials = usuarioRepository.findByLogin(login);

        if (userCredentials == null) {
            throw new UnauthorizedException("UnauthorizedException");
        }

        var autentication = new UsernamePasswordAuthenticationToken(userCredentials, null, userCredentials.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(autentication);

        return TokenResponseDto
                .builder()
                .token(geraTokenJwt(userCredentials,horaExpiracaoToken))
                .refreshToken(geraTokenJwt(userCredentials,horaExpiracaoRefreshToken))
                .build();
    }

    private Instant geraDataExpiracao(Integer expiration) {
        return LocalDateTime.now()
                .plusHours(expiration)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
