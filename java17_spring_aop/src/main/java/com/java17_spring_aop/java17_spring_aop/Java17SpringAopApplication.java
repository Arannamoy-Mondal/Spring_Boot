package com.java17_spring_aop.java17_spring_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Java17SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java17SpringAopApplication.class, args);
	}

}
