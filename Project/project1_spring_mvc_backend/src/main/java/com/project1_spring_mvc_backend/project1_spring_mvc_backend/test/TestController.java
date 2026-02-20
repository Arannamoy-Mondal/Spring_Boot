package com.project1_spring_mvc_backend.project1_spring_mvc_backend.test;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class TestController {
    @GetMapping("/api/v1/test")
    public String getTest() {
        return new String("Ok");
    }
    
}
