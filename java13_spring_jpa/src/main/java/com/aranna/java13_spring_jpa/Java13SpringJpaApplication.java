package com.aranna.java13_spring_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Java13SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java13SpringJpaApplication.class, args);
	}

}
