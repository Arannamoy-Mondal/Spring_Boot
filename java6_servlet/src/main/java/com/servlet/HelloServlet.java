package com.servlet;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    public void service(HttpServlet req,HttpServletResponse res){
        System.out.println("Hello in service");
        
    }
    
}
