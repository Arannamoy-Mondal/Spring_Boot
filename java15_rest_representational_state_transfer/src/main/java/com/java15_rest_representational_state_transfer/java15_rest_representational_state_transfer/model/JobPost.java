package com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.model;


import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {
    private int PostId;
    private String postProfile;
    private String poStringDesc;
    private Integer reqExperience;
    private List<String> postTechStack;
}
