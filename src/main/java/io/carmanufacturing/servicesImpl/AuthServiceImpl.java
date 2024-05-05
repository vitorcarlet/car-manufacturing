package io.carmanufacturing.servicesImpl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.carmanufacturing.dtos.AuthDto;
import io.carmanufacturing.dtos.TokenResponseDto;
import io.carmanufacturing.A1Infrastructure.exceptions.UnauthorizedException;
import io.carmanufacturing.persistence.UserCredentialsEntity;
import io.carmanufacturing.persistence.UserEntity;
import io.carmanufacturing.persistence.UserPermissionsEntity;
import io.carmanufacturing.respositories.UserCredentialsRepository;
import io.carmanufacturing.respositories.UserRepository;
import io.carmanufacturing.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Value("${auth.jwt.token.secret}")
//    private String secretKey;
//
//    @Value("${auth.jwt.token.expiration}")
//    private Integer horaExpiracaoToken;
//
//    @Value("${auth.jwt.refresh-token.expiration}")
//    private Integer horaExpiracaoRefreshToken ;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return (UserDetails) userCredentialsRepository.findByLogin(login);
    }

    @Override
    public TokenResponseDto obterToken(AuthDto authDto) {
        UserCredentialsEntity userCredentials = userCredentialsRepository.findByLogin(authDto.login());

        return TokenResponseDto
                .builder()
                .token(geraTokenJwt(userCredentials,3600))
                .refreshToken(geraTokenJwt(userCredentials,3600))
                .build();
    }

    public  String geraTokenJwt(UserCredentialsEntity userCredentials, Integer expiration) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("asd");
            
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
            Algorithm algorithm = Algorithm.HMAC256("asd");

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
        UserCredentialsEntity userCredentials = userCredentialsRepository.findByLogin(login);

        UserEntity user = userCredentials.getUserId();
        UserPermissionsEntity userPermissions = user.getUserPermissionsEntity();



        if (userCredentials == null) {
            throw new UnauthorizedException("UnauthorizedException");
        }

        var autentication = new UsernamePasswordAuthenticationToken(userCredentials, null, userCredentials.getAuthorities(userPermissions));

        SecurityContextHolder.getContext().setAuthentication(autentication);

        return TokenResponseDto
                .builder()
                .token(geraTokenJwt(userCredentials,3600))
                .refreshToken(geraTokenJwt(userCredentials,3600))
                .build();
    }

    private Instant geraDataExpiracao(Integer expiration) {
        return LocalDateTime.now()
                .plusHours(expiration)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
