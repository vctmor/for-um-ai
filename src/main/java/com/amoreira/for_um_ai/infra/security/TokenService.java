package com.amoreira.for_um_ai.infra.security;


import com.amoreira.for_um_ai.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){

      try {

          var algorithm  = Algorithm.HMAC256(secret);

          return JWT.create()
                  .withIssuer("API for-um-ai")
                  .withSubject(user.getUsername())
                  .withExpiresAt(expirationDate())
                  .sign(algorithm);

      } catch (JWTCreationException e) {

          throw new RuntimeException("erro ao gerar token jwt", e);
      }
    }

    public String getSubject(String tokenJWT){

        try{
            var algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("API for-um-ai")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTCreationException e ) {
            throw new RuntimeException("token JWT inválido ou expirado!");
        }
    }

    private Instant expirationDate(){

        return LocalDateTime.now().plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
