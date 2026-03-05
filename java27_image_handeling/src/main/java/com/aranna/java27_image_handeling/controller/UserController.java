package com.aranna.java27_image_handeling.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aranna.java27_image_handeling.model.User;

import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping(value = "/signup",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> justTesting(@RequestPart("image") MultipartFile image,@RequestPart String entity) {
        try{
           ObjectMapper objectMapper=new ObjectMapper();
        User user=objectMapper.readValue(entity, User.class);
        user.setImage(image.getBytes());
        return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
    }
    
}
