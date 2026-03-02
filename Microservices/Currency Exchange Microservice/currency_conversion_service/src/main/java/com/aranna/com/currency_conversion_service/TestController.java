package com.aranna.com.currency_conversion_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/get")
    public String getMethodName(@RequestParam String param) {
        return new String("Hello");
    }
    
}
