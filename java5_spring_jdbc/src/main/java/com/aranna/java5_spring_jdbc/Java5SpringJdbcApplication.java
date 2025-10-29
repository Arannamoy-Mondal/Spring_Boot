package com.aranna.java5_spring_jdbc;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aranna.java5_spring_jdbc.Student.Student;
import com.aranna.java5_spring_jdbc.Student.StudentService;

@SpringBootApplication
public class Java5SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Java5SpringJdbcApplication.class, args);
		Student std=context.getBean(Student.class);
		std.setAge(22);
		std.setName("Student Three");
		std.setId(3);
		StudentService stdS=context.getBean(StudentService.class);
		stdS.addStudent(std);
		List<Student> students=stdS.getStudents();
		System.out.println(students);

	}

}
