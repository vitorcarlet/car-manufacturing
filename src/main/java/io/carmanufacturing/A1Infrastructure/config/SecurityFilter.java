package io.carmanufacturing.A1Infrastructure.config;

import io.carmanufacturing.entities.UserCredentials;
import io.carmanufacturing.A1Infrastructure.exceptions.UnauthorizedException;
import io.carmanufacturing.respositories.UsuarioRepository;
import io.carmanufacturing.services.AuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = extraiTokeHeader(request);

        if (token != null) {
            String login = authService.validaTokenJwt(token);
            UserCredentials userCredentials = usuarioRepository.findByLogin(login);

            if (userCredentials == null) {
                throw  new UnauthorizedException("Unauthorizad");
            }

            var autentication = new UsernamePasswordAuthenticationToken(userCredentials, null, userCredentials.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(autentication);
        }

        filterChain.doFilter(request, response);
    }

    public String extraiTokeHeader(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");

        if (authHeader == null) {
            return null;
        }

        if (!authHeader.split(" ")[0].equals("Bearer")) {
            return  null;
        }

        return authHeader.split(" ")[1];
    }
}
