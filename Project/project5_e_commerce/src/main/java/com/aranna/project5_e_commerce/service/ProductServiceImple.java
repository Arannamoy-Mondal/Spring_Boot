package com.aranna.project5_e_commerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aranna.project5_e_commerce.entity.Product;

import com.aranna.project5_e_commerce.model.ProductResponse;
import com.aranna.project5_e_commerce.repo.ProductRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImple implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductResponse> getAllProducts() {
        log.info("Fetching all products.");
        List<Product> products = productRepo.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            productResponses.add(ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .image(product.getImage())
                    .price(product.getPrice())
                    .brand(product.getBrand())
                    .description(product.getDescription())
                    .build());
        }
        return productResponses;
    }

    @Override
    public ProductResponse getProductById(Integer id) {
        Product product = productRepo.findById(id).orElse(null);
        ProductResponse productResponse = ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .image(product.getImage())
                .price(product.getPrice())
                .brand(product.getBrand())
                .description(product.getDescription())
                .build();
                return productResponse;
    }

}
