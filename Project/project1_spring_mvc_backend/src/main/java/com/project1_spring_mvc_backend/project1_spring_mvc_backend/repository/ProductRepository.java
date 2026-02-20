package com.project1_spring_mvc_backend.project1_spring_mvc_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Integer> {

    
} 
