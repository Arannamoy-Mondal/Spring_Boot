package com.aranna.java7_jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Hello {
    // @RequestMapping("/")
    @RequestMapping("/")
    public String hello(){
        System.out.println("hello");
        return "Hello.jsp";
    }

    @RequestMapping("add")
    // way 1
    // public String add(HttpServletRequest req,HttpSession session){
    //     int num1=Integer.parseInt(req.getParameter("num1"));
    //     int num2=Integer.parseInt(req.getParameter("num2"));
    //     int result=num1+num2;
    //     session.setAttribute("result", result);
    //     System.out.println(result);
    //     return "Hello.jsp";
    // }
    // way 2
    public String add(@RequestParam("num1") int num2,@RequestParam("num2") int num3,Model session){
        int result=num3+num2;
        session.addAttribute("result", result);
        System.out.println(result);
        return "Hello.jsp";
    }
}
