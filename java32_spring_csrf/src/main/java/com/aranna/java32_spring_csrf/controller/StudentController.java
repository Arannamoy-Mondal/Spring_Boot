package com.aranna.java32_spring_csrf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aranna.java32_spring_csrf.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/student")
public class StudentController {
    List<Student> students = new ArrayList<>(
            List.of(new Student(1, "One", "Spring"),
                    new Student(2, "Two", "Spring Boot"),
                    new Student(3, "Three", "Actix")));

    @GetMapping("")
    public List<Student> getStudents(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getAttribute("_csrf"));
        return students;
    }

    @GetMapping("/csrf")
    public Object getCsrf(HttpServletRequest httpServletRequest){
        return httpServletRequest.getAttribute("_csrf");
    }

    @PostMapping("/add")
    public List<Student> addStudent(@RequestBody Student std){
        students.add(std);
        // System.out.println(httpServletRequest.getAttribute("_csrf"));
        return students;
    }
}
