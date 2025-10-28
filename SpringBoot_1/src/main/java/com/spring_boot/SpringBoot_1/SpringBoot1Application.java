package com.spring_boot.SpringBoot_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringBoot1Application {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(SpringBoot1Application.class, args);
		Alien obj=context.getBean(Alien.class);
		obj.code();
		System.out.println("Hello");
	}

}


