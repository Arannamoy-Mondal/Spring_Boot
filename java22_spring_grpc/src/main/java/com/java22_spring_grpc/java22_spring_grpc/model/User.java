package com.java22_spring_grpc.java22_spring_grpc.model;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private float salary;
    private List<Department> departments;
    private Map<String,String> addressMap;
    private boolean isActive;
    private byte[] profilePicture;
    private Instant joinDate;
}
