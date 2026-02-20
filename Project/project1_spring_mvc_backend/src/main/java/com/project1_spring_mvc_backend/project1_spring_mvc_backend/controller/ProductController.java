package com.project1_spring_mvc_backend.project1_spring_mvc_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.ProductModel;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/load")
    public String loadProduct(){
        return productService.loadProduct();
    }
}
