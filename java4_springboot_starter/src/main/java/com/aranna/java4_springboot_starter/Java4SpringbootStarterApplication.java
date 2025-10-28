package com.aranna.java4_springboot_starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aranna.java4_springboot_starter.Alien.Alien;
import com.aranna.java4_springboot_starter.Laptop.Laptop;
import com.aranna.java4_springboot_starter.Laptop.LaptopService;

@SpringBootApplication
public class Java4SpringbootStarterApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Java4SpringbootStarterApplication.class, args);
		LaptopService laptopService=context.getBean(LaptopService.class);
		Laptop l=context.getBean(Laptop.class);
		laptopService.addLaptop(l);
	}

}
