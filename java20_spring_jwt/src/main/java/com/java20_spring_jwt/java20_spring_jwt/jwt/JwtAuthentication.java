package com.java20_spring_jwt.java20_spring_jwt.jwt;

import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class JwtAuthentication {

    private JwtEncoder jwtEncoder;
    public JwtAuthentication(JwtEncoder jwtEncoder){
        this.jwtEncoder=jwtEncoder;
    }
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


    @PostMapping("/authenticate/v1")
    public JwtResponse authenticateV1(Authentication authentication) {   
      return new JwtResponse(createToken(authentication));
    }

    private String createToken(Authentication authentication){
        var claim=JwtClaimsSet.builder().issuer("self")
        .issuedAt(Instant.now())
        .expiresAt(Instant.now().plusSeconds(60*24*60))
        .subject(authentication.getName())
        .claim("scope",createScope(authentication))
        .build();
        JwtEncoderParameters jwtEncoderParameters=JwtEncoderParameters.from(claim);
        return jwtEncoder.encode(jwtEncoderParameters.from(claim)).getTokenValue();
    }
    private String createScope(Authentication authentication) {
        return authentication.getAuthorities().stream().map(a->a.getAuthority())
        .collect(Collectors.joining(""));
    }
    
}


record JwtResponse(String token) {


}
