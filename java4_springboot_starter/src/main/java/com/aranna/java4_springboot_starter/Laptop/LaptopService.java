package com.aranna.java4_springboot_starter.Laptop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository repo;
    public void addLaptop(Laptop l){
        repo.save(l);
        System.out.println("Method called!");
    }
    public boolean isGoodForProgramming(Laptop l){
        return true;
    }
}
