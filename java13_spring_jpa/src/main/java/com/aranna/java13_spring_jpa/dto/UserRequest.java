package com.aranna.java13_spring_jpa.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aranna.java13_spring_jpa.model.Role;

import lombok.Data;

@Data
@Component
public class UserRequest {
    // private int id;
    private String name;
    private List<String> roles;
    private int passportId;
    private String country;
    // private List<Integer> vehicleId;
    private int vehicleId;
}
