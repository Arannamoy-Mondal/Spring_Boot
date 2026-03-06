package com.aranna.project5_e_commerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aranna.project5_e_commerce.entity.Brand;
import com.aranna.project5_e_commerce.entity.Product;
import com.aranna.project5_e_commerce.entity.Type;
import com.aranna.project5_e_commerce.repo.BrandRepo;
import com.aranna.project5_e_commerce.repo.ProductRepo;
import com.aranna.project5_e_commerce.repo.TypeRepo;
import com.aranna.project5_e_commerce.service.BrandService;
import com.aranna.project5_e_commerce.service.ProductService;
import com.aranna.project5_e_commerce.service.TypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private ProductRepo productRepo;



    @GetMapping("/test")
    public ResponseEntity<?> getMethodName() {
       
        return ResponseEntity.status(HttpStatus.OK).body(productRepo.findAll());
    }
    



    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
        try{
           return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
    }

     @GetMapping()
    public ResponseEntity<?> getProducts(
      @RequestParam(name = "page",defaultValue = "0") int page,
      @RequestParam(name="size",defaultValue = "10") int size,
      @RequestParam(name = "keyword",required = false) String keyword,
      @RequestParam(name="brandId",required = false) Integer brandId,
      @RequestParam(name = "typeId",required = false) Integer typeId,
      @RequestParam(name = "sort",defaultValue = "name") String sort,
      @RequestParam(name = "order",defaultValue = "asc") String order
    ) {
        try{
          Sort.Direction direction=order.equalsIgnoreCase("desc")?Sort.Direction.DESC:Sort.Direction.ASC;
          Sort sorting=Sort.by(direction,sort);
          Pageable pageable=PageRequest.of(page, size,sorting);
           return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts(pageable,brandId,typeId,keyword));
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
    }
    
    @GetMapping("/brand")
    public ResponseEntity<?> getBrands() {
        try{
           return ResponseEntity.status(HttpStatus.OK).body(brandService.getAllBrands());
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
    }
    @GetMapping("/type")
    public ResponseEntity<?> getTypes() {
        try{
           return ResponseEntity.status(HttpStatus.OK).body(typeService.getAllTypes());
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
    }
    
}
