package com.manuel.bookstore.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.manuel.bookstore.dto.UserDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAuthProvider {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @PostConstruct
    protected  void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(UserDto userDto){
        var currentDate = new Date();
        var validity = new Date(currentDate.getTime() + 3_600_000);
        return JWT.create()
                .withIssuer(userDto.getEmail())
                .withIssuedAt(currentDate)
                .withExpiresAt(validity)
                .withClaim("firstName", userDto.getFirstName())
                .withClaim("lastName", userDto.getLastName())
                .withClaim("email", userDto.getEmail())
                .sign(Algorithm.HMAC256(secretKey));
    }

    public UsernamePasswordAuthenticationToken validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        var userDto = new UserDto(UUID.randomUUID(), decodedJWT.getClaim("firstName").asString(), decodedJWT.getClaim("lastName").asString(),
                decodedJWT.getClaim("email").asString(),"", decodedJWT.getIssuer());

        return new UsernamePasswordAuthenticationToken(userDto, null, Collections.emptyList());
    }
}
