package com.aranna.java4_springboot_starter.Laptop;

import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save(Laptop l){
        System.out.println("save method called");
    }
    
}
