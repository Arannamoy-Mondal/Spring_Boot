package com.aranna.java30_sorting_pagination.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aranna.java30_sorting_pagination.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public ResponseEntity<?> getMethodName(@RequestParam(defaultValue = "0") int pageNum
    ,
    @RequestParam(defaultValue = "0") int pageSize
    ,
    @RequestParam(defaultValue = "asc") String sortDir
    ,
    @RequestParam(defaultValue = "id") String sortBy
) {
        try{

           return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageNum,pageSize,sortDir,sortBy));
        } catch (Exception e) {
          System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}
