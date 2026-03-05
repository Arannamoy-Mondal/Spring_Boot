package com.aranna.accounts.test;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {
    @GetMapping("/test")
    public ResponseEntity<?> getMethodName() {
        try {
            Test test = Test.builder().id(10).description("Hello").build();
            return ResponseEntity.status(HttpStatus.OK).body(test);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
    }

}
