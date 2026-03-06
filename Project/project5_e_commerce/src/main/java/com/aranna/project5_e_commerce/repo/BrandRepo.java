package com.aranna.project5_e_commerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aranna.project5_e_commerce.entity.Brand;

public interface BrandRepo extends JpaRepository<Brand,Integer>{
    Brand findByName(String name);
}
