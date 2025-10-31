package com.aranna.java11_project_job_portal.repository;

import java.util.ArrayList;
import java.util.List;

import com.aranna.java11_project_job_portal.model.JobPost;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class JobRepository {
    public static List<JobPost> jobList=new ArrayList<>();
}
