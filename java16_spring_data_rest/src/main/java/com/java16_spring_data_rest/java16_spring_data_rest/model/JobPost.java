package com.java16_spring_data_rest.java16_spring_data_rest.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobPostId;
    private String jobPostProfile;
    private String jobPostDesc;
    private Integer jobReqExperience;
    private List<String> jobPostTechStack;
}
