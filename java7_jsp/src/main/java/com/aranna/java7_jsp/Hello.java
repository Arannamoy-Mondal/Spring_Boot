package com.aranna.java7_jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
    // @RequestMapping("/")
    @GetMapping("/")
    public String hello(){
        System.out.println("hello");
        return "Hello";
    }
}
