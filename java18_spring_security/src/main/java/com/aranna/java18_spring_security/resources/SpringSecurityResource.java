package com.aranna.java18_spring_security.resources;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityResource {
    @GetMapping("/csrf-token")
    public CsrfToken     retrieveCSRFToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
