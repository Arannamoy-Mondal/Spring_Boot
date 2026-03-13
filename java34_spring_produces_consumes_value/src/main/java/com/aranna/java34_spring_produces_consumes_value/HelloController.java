package com.aranna.java34_spring_produces_consumes_value;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @PostMapping(value = "/post",consumes =MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> postHello(
        @RequestParam(required = false) MultipartFile image
    ){
        return (ResponseEntity<?>) image; 
    }
}
