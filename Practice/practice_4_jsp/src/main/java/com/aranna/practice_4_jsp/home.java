package com.aranna.practice_4_jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class home {
    @RequestMapping("/")
    public String Home(){
        return "home.jsp";
    }
}
