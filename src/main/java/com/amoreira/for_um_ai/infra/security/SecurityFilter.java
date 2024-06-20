package com.amoreira.for_um_ai.infra.security;

import com.amoreira.for_um_ai.domain.user.User;
import com.amoreira.for_um_ai.domain.user.UserRepositry;
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
import java.security.Security;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepositry repositry;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = retrievingToken(request);

        System.out.println("Novo ytken emitido: " + tokenService.generateToken(new User(3L, "aline", "123")));

        if (tokenJWT != null){

            var subject = tokenService.getSubject(tokenJWT);
            var user = repositry.findByLogin(subject);

            var authentication =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        //System.out.println(subject);
        filterChain.doFilter(request,response);


    }

    private String retrievingToken(HttpServletRequest request) {

        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null){

            return  authorizationHeader.replace("Bearer ", "");
        }

        return null;
    }
}
