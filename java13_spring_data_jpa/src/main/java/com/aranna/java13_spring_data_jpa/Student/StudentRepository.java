package com.aranna.java13_spring_data_jpa.Student;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.name=?1") // method works without it but not everytime. this is exceptional
    List<Student> findByName(String name);
    List<Student> findByMarks(int marks);
}
