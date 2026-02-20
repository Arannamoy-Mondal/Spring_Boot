package com.project1_spring_mvc_backend.project1_spring_mvc_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.ProductModel;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.repository.ProductRepository;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.FOUND);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable("productId") int productId){
        return new ResponseEntity<>(productService.findById(productId),HttpStatus.FOUND);
    }
    @GetMapping("/load")
    public ResponseEntity<String> loadProduct(){
        return new ResponseEntity<>(productService.loadProduct(),HttpStatus.OK);
    }
}
