package com.aranna.java3_working_javabased_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Value("A")
    public String name;
    // public String name="A";
    @Autowired
    public Laptop l;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Laptop getL() {
        return l;
    }
    public void setL(Laptop l) {
        this.l = l;
    }
    public void code(){
        l.compile();
        System.out.println("Coding");
    }
    @Override
    public String toString() {
        return "Alien [name=" + name + ", l1=" + l + "]";
    }
    
}
