package com.aranna.java3_working_javabased_configuration;

import org.springframework.stereotype.Component;

@Component
public class Laptop {

    public void compile(){
        System.out.println("Compile");
    }

    @Override
    public String toString() {
        return "Laptop []";
    }
    
}
