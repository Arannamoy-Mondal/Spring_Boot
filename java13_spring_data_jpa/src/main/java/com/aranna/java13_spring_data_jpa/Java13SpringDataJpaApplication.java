package com.aranna.java13_spring_data_jpa;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aranna.java13_spring_data_jpa.Student.Student;
import com.aranna.java13_spring_data_jpa.Student.StudentRepository;

@SpringBootApplication
public class Java13SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=
		SpringApplication.run(Java13SpringDataJpaApplication.class, args);
		Student std1=context.getBean(Student.class);
		std1.setId(1);
		std1.setName("Krish");
		std1.setMarks(100);
		StudentRepository repo=context.getBean(StudentRepository.class);
		repo.save(std1);
		Student std2=context.getBean(Student.class);
		std2.setId(2);
		std2.setName("Zara");
		std2.setMarks(100);
		repo.save(std2);
		System.out.println(repo.findAll());
		System.out.println(repo.count());
		System.out.println(repo.findById(1));
		System.out.println(repo.findByName("Krish"));  // check it StudentRepository interface
		System.out.println(repo.findByMarks(100));

		Optional<Student> result=repo.findById(1);
		Student updateStudent=result.get();
		updateStudent.setMarks(101);
		repo.save(updateStudent);
		System.out.println(repo.findAll());


		repo.deleteById(1);
		
	}

}
