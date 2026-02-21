package com.project1_spring_mvc_backend.project1_spring_mvc_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.ProductModel;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.service.ProductService;

import tools.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.FOUND);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable("productId") int productId) {
        return new ResponseEntity<>(productService.findById(productId), HttpStatus.FOUND);
    }

    @GetMapping("/load")
    public ResponseEntity<String> loadProduct() {
        return new ResponseEntity<>(productService.loadProduct(), HttpStatus.OK);
    }

    @PostMapping(value = "/add",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProduct(
            @RequestPart("productJson") String productJson,
            @RequestPart("image") MultipartFile image) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            ProductModel product = mapper.readValue(productJson, ProductModel.class);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(productService.addProduct(product, image));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}

/*
 * {
 * "name": "Core i9-14900K",
 * "description": "24-Core Unlocked Desktop Processor",
 * "brand": "Intel",
 * "price": 45000.00,
 * "category": "Electronics",
 * "releaseDate": "17-10-2023",
 * "productAvailable": true,
 * "stockQuantity": 120
 * }
 */