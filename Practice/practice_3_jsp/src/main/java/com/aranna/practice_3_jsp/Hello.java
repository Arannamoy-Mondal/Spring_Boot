package com.aranna.practice_3_jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
    // @GetMapping("/")
    @RequestMapping("/")
    public String hello(){
        System.out.println("hello method called");
        return "Hello.jsp";
    }
}
