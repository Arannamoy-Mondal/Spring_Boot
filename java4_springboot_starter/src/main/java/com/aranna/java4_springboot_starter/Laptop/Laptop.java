package com.aranna.java4_springboot_starter.Laptop;

import org.springframework.stereotype.Component;

import com.aranna.java4_springboot_starter.Desktop.Desktop;

@Component
public class Laptop implements Desktop {
    @Override
    public void compile(){
        System.out.println("Compile");
    }    
}
