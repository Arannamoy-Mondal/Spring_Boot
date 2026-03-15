package com.aranna.java20_spring_jwt_using_nimbus_jose.config;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class JwtTokenGenerate {
    private final Environment environment;
    // private final String SECRET_STRING;
    // private SecretKey secretKey;
    // public Jwt(){
    //     // this.environment=environment;
    //     this.secretKey=Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));
    // }
    public String generatJwtToken(Authentication authentication){
        String jwtToken;
        String secretString=environment.getProperty("SECRET_STRING");
        SecretKey secretKey=Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
        var fetchUser=(User)authentication.getPrincipal();
        jwtToken=Jwts.builder()
        .issuer("hello")
        .subject("JwtToken")
        .claim("userName", fetchUser.getUsername())
        .issuedAt(new Date())
        .expiration(new Date(new Date().getTime()+24*60*60*1000))
        .signWith(secretKey)
        .compact();
        return jwtToken;
    }
}
