package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/authenticate")
public class SecurityController {
    @GetMapping("/get/csrf") // enable csrf(Customizer.withDefaults()) from SecurityConfiguraion.java
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }
}
