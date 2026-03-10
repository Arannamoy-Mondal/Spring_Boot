package com.java20_spring_jwt.java20_spring_jwt.jwt;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class JwtAuthentication {
    @PostMapping("/authenticate")
    public Map<String, Object> authenticate(Authentication authentication) {   
        if (authentication == null) {
        throw new RuntimeException("Authentication failed or is null!");
    }
        Map<String, Object> response = new HashMap<>();
        response.put("username", authentication.getName());
        response.put("authorities", authentication.getAuthorities());
        response.put("isAuthenticated", authentication.isAuthenticated());
        return response;
    }
    
}
