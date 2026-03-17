package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }
}
