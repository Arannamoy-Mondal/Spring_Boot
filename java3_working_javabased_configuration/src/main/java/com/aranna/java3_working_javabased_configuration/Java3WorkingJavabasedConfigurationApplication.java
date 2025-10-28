package com.aranna.java3_working_javabased_configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aranna.java3_working_javabased_configuration.AppConfig.AppConfig;

@SpringBootApplication
public class Java3WorkingJavabasedConfigurationApplication {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		Alien a=context.getBean(Alien.class);
		a.code();
		Alien a1=context.getBean(Alien.class);
		a1.setName("B");
		a1.code();
		System.out.println(a);
		// SpringApplication.run(Java3WorkingJavabasedConfigurationApplication.class, args);
	}

}
