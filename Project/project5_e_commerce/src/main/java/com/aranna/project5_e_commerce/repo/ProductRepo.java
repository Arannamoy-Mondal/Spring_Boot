package com.aranna.project5_e_commerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aranna.project5_e_commerce.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{

}
