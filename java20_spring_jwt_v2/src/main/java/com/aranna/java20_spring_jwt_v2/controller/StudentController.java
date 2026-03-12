package com.aranna.java20_spring_jwt_v2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aranna.java20_spring_jwt_v2.model.Student;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/students")
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(new Student(1, "One", "Spring"),
            new Student(2, "Two", "Spring Boot"),
            new Student(3, "Three", "Actix"),
            new Student(4, "Four", "Rocket")));
    @GetMapping("")
    public List<Student> getStudents(HttpServletRequest httpServletRequest){
        System.out.println(httpServletRequest.getSession().getId());
        return students;
    }


    @PostMapping("/add")
    public List<Student> addStudent(@RequestBody Student entity) {
        students.add(entity);
        return students;
    }
    
}
