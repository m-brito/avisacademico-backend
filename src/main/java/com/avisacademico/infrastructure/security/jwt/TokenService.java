package com.avisacademico.infrastructure.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.avisacademico.domain.model.user.User;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TokenService {

    private static final String issuer = "avisacademico";

    @Value("${avisacademico.password.generate.token}")
    private String secret;
    private Algorithm algorithm = Algorithm.HMAC256(secret);

    public String generateToken(User user){
        try {
            String token = JWT.create()
                    .withSubject(user.getId().toString())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);

            return token;
        }catch (JWTCreationException ex){
            throw new RuntimeException("Failed to generate token");
        }
    }

    public String getSubject(String token){
        try {
            JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();

            return jwtVerifier.verify(token).getSubject();
        }catch (JWTVerificationException ex){
            throw new RuntimeException("Expired or invalid Token JWT.");
        }
    }

    private Instant expirationDate(){
        return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"));
    }
}
