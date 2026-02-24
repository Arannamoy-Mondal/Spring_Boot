package com.java18_spring_security_project.java18_spring_security_project.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/get")
    public String test(HttpServletRequest request){
        return "Test Ok "+request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request){
        return "about "+request.getSession().getId();
    }
}
