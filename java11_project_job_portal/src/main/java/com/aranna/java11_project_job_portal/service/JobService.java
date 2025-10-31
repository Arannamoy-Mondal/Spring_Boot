package com.aranna.java11_project_job_portal.service;

import java.util.Arrays;
import java.util.List;

import com.aranna.java11_project_job_portal.model.JobPost;
import com.aranna.java11_project_job_portal.repository.JobRepository;

public class JobService {

    public static void addjob(JobPost jobPost){
        JobRepository.jobList.add(jobPost);
    }

    public static List<JobPost> getAllJobs(){
        return JobRepository.jobList;
    }
}
