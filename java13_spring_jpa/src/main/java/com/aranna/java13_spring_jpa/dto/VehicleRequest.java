package com.aranna.java13_spring_jpa.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class VehicleRequest {
     private String model;
     private String vehicleType;
}   
