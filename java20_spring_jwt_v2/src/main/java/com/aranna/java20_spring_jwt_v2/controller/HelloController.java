package com.aranna.java20_spring_jwt_v2.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;





@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getMethodName(HttpServletRequest httpServletRequest) {
        return new String("Hello"+" "+httpServletRequest.getSession().getId());
    }
    
    @GetMapping("/about")
    public String getMethodName1() {
        return new String("About");
    }
    
}
