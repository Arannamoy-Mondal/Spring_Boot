package com.aranna.java1001_spring_test_from_podman_or_docker_or_local_netwrok;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @GetMapping("/home")
    public String home(){
        System.out.println("Home method called.");
        return "Hello";
    }
}
