package com.spring_boot.SpringBoot_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    // Laptop l1=new Laptop();
    @Autowired
    Laptop l1;
    public void code(){
        l1.compile();
        System.out.println("Coding");
    }
    
}