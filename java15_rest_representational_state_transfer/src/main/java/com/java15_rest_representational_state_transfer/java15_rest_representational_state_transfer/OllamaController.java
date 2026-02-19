package com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class OllamaController {
    @GetMapping("/api/v1/check")
    public String getCheck() {
        return "Ok";
    }

    @PostMapping("/api/v1/check")
    public String postCheck(@RequestParam String data,@RequestBody String body) {
        System.out.println(body);
        return data;
    }
    
    
}
