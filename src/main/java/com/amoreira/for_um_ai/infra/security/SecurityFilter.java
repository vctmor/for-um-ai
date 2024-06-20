package com.amoreira.for_um_ai.infra.security;

import com.amoreira.for_um_ai.domain.user.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = retrievingToken(request);
        System.out.println("Novo ytken emitido: " + tokenService.generateToken(new User(3L, "aline", "123")));
        var subject = tokenService.getSubject("Pessoa 'logada'" + tokenJWT);

        System.out.println(subject);
        filterChain.doFilter(request,response);


    }

    private String retrievingToken(HttpServletRequest request) {

        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null){
            throw new RuntimeException("Token JWT não enviado no cabeçalho Authorization!");
        }

        return  authorizationHeader.replace("Bearer ", "");
    }
}
