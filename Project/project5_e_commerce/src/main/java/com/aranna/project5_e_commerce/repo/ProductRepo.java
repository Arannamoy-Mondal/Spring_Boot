package com.aranna.project5_e_commerce.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aranna.project5_e_commerce.entity.Product;



public interface ProductRepo extends JpaRepository<Product,Integer>{
    Page<Product> findAll(Specification<Product> spec,Pageable pageable);
    Specification<Product> searchByNameContaining(String keyword);
    Specification<Product> findByBrandId(Integer id);
    Specification<Product> findByTypeId(Integer id);
    Specification<Product> findByBrandAndType(Integer brandId,Integer typeId);
}
