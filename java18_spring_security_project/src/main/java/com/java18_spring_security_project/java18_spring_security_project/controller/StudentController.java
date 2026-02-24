package com.java18_spring_security_project.java18_spring_security_project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java18_spring_security_project.java18_spring_security_project.model.Student;
import com.java18_spring_security_project.java18_spring_security_project.repo.StudentRepo;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @GetMapping("/load")
    public ResponseEntity<List<Student>> loadData(){
    Student std1=Student.builder()
    .name("Null")
    .tech("Cobol,Rust,Java,Solidity,Blockchain,Machine Learning")
    .build();
    studentRepo.save(std1);
    return ResponseEntity.status(HttpStatus.OK).body(studentRepo.findAll());
    }
    
}
