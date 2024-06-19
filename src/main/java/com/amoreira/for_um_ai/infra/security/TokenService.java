package com.amoreira.for_um_ai.infra.security;


import com.amoreira.for_um_ai.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generateToken(User user){

      try {

          var algorithm  = Algorithm.HMAC256("12345678");

          return JWT.create()
                  .withIssuer("API for-um-ai")
                  .withSubject(user.getUsername())
                  .withExpiresAt(expirationDate())
                  .sign(algorithm);

      } catch (JWTCreationException e) {

          throw new RuntimeException("erro ao gerar token jwt", e);
      }
    }

    private Instant expirationDate(){

        return LocalDateTime.now().plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
