package com.project1_spring_mvc_backend.project1_spring_mvc_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
    @Query("SELECT p FROM ProductModel p WHERE " +
           "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<ProductModel> searchProduct(String keyword);
} 
