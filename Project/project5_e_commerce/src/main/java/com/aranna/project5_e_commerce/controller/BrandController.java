package com.aranna.project5_e_commerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aranna.project5_e_commerce.service.BrandService;




@RestController
@RequestMapping("/api/v1/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping("/get")
    public ResponseEntity<?> getBrands(){
        try{
            System.out.println(brandService.getAllBrands());
           return ResponseEntity.status(HttpStatus.OK).body(brandService.getAllBrands());
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
    }
    
}
