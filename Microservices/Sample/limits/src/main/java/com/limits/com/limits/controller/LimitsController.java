package com.limits.com.limits.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limits.com.limits.configuration.Configuration;
import com.limits.com.limits.entity.Limits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/limits")
public class LimitsController {
    @Autowired
    private Configuration configure;
    @GetMapping("/get")
    public ResponseEntity<?> getMethodName() {
        return ResponseEntity.status(HttpStatus.OK).body(new Limits(configure.getMinimum(), configure.getMaximum()));
    }
    
}
