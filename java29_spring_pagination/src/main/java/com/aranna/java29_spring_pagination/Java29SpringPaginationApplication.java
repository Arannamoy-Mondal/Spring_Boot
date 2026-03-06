package com.aranna.java29_spring_pagination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Java29SpringPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java29SpringPaginationApplication.class, args);
	}

}
