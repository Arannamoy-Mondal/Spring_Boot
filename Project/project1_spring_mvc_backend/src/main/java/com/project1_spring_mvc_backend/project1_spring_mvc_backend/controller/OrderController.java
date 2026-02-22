package com.project1_spring_mvc_backend.project1_spring_mvc_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.dto.OrderRequest;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin()
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/place")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest){
        // return ResponseEntity.status(HttpStatus.OK).body("ok");
        return ResponseEntity.status(HttpStatus.OK).body(orderService.placeOrder(orderRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getOrder(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder());
    }
}
