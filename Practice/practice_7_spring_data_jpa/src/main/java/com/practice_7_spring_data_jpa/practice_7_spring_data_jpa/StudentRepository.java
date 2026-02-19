package com.practice_7_spring_data_jpa.practice_7_spring_data_jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    
} 
