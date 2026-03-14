package com.aranna.java20_spring_jwt_using_nimbus_jose.config;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class Jwt {
    public String generatJwtTokeString(Authentication authentication){
        String jwtToken=null;
        return jwtToken;
    }
}
