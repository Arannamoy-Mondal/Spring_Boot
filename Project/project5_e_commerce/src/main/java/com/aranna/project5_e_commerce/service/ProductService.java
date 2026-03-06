package com.aranna.project5_e_commerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aranna.project5_e_commerce.model.ProductResponse;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Integer id);
    Page<ProductResponse> getProducts(Pageable pageable,Integer brandId,Integer typerId,String keyword);
}
