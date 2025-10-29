package com.servlet;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Tomcat tomcat=new Tomcat();
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tomcat.getServer().await();
    }
}