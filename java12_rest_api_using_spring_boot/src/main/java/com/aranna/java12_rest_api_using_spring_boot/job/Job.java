package com.aranna.java12_rest_api_using_spring_boot.job;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    public int id;
    public String jobProfile;
    public String jobDesc;
    public String exp;
    public List<String> techStack=new ArrayList<>();
}
