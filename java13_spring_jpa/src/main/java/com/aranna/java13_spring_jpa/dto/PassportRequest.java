package com.aranna.java13_spring_jpa.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PassportRequest {
    private String country;
}
