package com.voiture.occasion.config.auth;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.voiture.occasion.model.Utilisateur;

@Service
public class TokenProvider {

  @Value("${security.jwt.token.secret-key}")
  private String JWT_SECRET;

  public String generateAccessToken(Utilisateur user) {
      try {
      Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
      return JWT.create()
          .withSubject(user.getIdUtilisateur())
          .withClaim("username", user.getIdUtilisateur())
          .withExpiresAt(genAccessExpirationDate())
          .sign(algorithm);
      } catch (JWTCreationException exception) {
          throw new JWTCreationException("Error while generating token", exception);
      }
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
      return JWT.require(algorithm)
          .build()
          .verify(token)
          .getSubject();
    } catch (JWTVerificationException exception) {
      throw new JWTVerificationException("Error while validating token", exception);
    }
  }

    private Instant genAccessExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
