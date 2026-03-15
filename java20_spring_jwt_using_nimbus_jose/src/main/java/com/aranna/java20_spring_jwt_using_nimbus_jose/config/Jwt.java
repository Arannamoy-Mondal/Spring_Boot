package com.aranna.java20_spring_jwt_using_nimbus_jose.config;

import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Jwt {
    private final Environment environment;
    public String generatJwtTokeString(Authentication authentication){
        String jwtToken=null;
        return jwtToken;
    }
}
