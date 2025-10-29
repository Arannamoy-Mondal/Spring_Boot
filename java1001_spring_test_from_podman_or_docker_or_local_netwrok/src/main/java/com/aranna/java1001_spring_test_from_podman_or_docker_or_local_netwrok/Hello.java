package com.aranna.java1001_spring_test_from_podman_or_docker_or_local_netwrok;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Hello {

    @GetMapping("/")
    public String getMethodName() {
        return "Hello";
    }
    
    
}
