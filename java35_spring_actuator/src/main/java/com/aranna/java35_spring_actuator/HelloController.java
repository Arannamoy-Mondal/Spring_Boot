package com.aranna.java35_spring_actuator;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    @GetMapping("")
    public String getMethodName(@RequestParam(required = false) String param) {
        return new String("Hello");
    }
    
}
