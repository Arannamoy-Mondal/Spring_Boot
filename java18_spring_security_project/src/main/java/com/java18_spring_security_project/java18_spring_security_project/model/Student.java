package com.java18_spring_security_project.java18_spring_security_project.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    private int id;
    private String name;
    private String tech;
}
