package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.controller;
import java.time.Instant;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.dto.JwtResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/authenticate")
public class SecurityController {

    @Autowired
    private JwtEncoder jwtEncoder;

    @GetMapping("/get/csrf") // enable csrf(Customizer.withDefaults()) from SecurityConfiguraion.java
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest) {
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @PostMapping("/get-jwt")
    public JwtResponse authenticate(Authentication authentication) {
        // return authentication;
        // System.out.println(authentication.getCredentials());
        return new JwtResponse(createToken(authentication));
        // return null;
    }

    private String createToken(Authentication authentication) {
        var claims = JwtClaimsSet.builder()
                // .issuedAt("Self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusMillis(1000 * 60 * 60 * 24))
                .claim("scope", createScope(authentication))
                .build();
        JwtEncoderParameters parameters = JwtEncoderParameters.from(claims);
        return jwtEncoder.encode(parameters).getTokenValue();
    }

    private String createScope(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(a -> a.getAuthority()).collect(Collectors.joining(" "));
    }
}

