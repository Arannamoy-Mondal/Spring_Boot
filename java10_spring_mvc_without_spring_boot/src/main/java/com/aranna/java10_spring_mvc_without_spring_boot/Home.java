package com.aranna.java10_spring_mvc_without_spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {
 @RequestMapping("/")
    public String home() {
        System.out.println("home method called");
        return "home";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int num3, @RequestParam("num2") int num4,ModelAndView mv) {
        int result=num3+num4;
        mv.addObject("result", result);
        mv.setViewName("home");
        return mv;
    }   
}
