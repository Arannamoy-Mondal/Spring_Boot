package com.aranna.project5_e_commerce.service;

import java.util.List;

import com.aranna.project5_e_commerce.model.ProductResponse;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Integer id);
}
