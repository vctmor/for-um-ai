package com.amoreira.for_um_ai.controller;

import com.amoreira.for_um_ai.domain.user.DataAuthentication;
import com.amoreira.for_um_ai.domain.user.User;
import com.amoreira.for_um_ai.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutentificationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAuthentication data){

        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());

        var authentification = manager.authenticate(token);

        return ResponseEntity.ok(tokenService.generateToken((User) authentification.getPrincipal()));

    }
}
