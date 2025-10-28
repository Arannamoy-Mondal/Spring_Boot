package com.aranna.java5_spring_jdbc.Student;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository stdRepo;

    public void addStudent(Student std) {
        stdRepo.save(std); 
        System.out.println("addStudent method called");
    }

    public List<Student> getStudents(){
        return stdRepo.getStudents();
    }

    @Autowired
    public StudentRepository getStdRepo() {
        return stdRepo;
    }

    public void setStdRepo(StudentRepository stdRepo) {
        this.stdRepo = stdRepo;
    }
}
