package com.servlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Tomcat tomcat=new Tomcat();
        tomcat.setHostname("0.0.0.0");
        tomcat.setPort(8000);
        try {
            Context context=tomcat.addContext("", null);
            Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
            context.addServletMappingDecoded("/hello", "HelloServlet");
            tomcat.start();
        } catch (LifecycleException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        tomcat.getServer().await();
    }
}