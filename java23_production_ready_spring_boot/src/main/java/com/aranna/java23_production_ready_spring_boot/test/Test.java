package com.aranna.java23_production_ready_spring_boot.test;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Test {
    @GetMapping("/test")
    public String getMethodName() {
        return new String("Ok");
    }
    
}
