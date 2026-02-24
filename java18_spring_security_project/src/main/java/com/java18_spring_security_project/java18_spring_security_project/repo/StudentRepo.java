package com.java18_spring_security_project.java18_spring_security_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java18_spring_security_project.java18_spring_security_project.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

}
