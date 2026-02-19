package com.practice_7_spring_data_jpa.practice_7_spring_data_jpa;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Practice7SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=
		SpringApplication.run(Practice7SpringDataJpaApplication.class, args);
		StudentRepository repo=context.getBean(StudentRepository.class);
		Student std1=context.getBean(Student.class);
		std1.setRoll(101);
		std1.setName("Practice 71");
		// repo.save(std1);
		Optional<Student> std2=repo.findById(2);	
		System.out.println(repo.findAll());
		System.out.println(repo.findById(1));
		System.out.println(std2);
	}

}
