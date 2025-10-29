package com.aranna.practice_1_jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class Hello {
    @GetMapping("/")
    public String hello(){
        System.out.println("Hello");
        return "Hello";
    }
}
