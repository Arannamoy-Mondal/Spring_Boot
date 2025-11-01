package com.aranna.java12_rest_api_using_spring_boot.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobService {
    @Autowired
    public JobRepository jobRepo;
    public void addJob(Job job){
        jobRepo.addJob(job);
    }

    public List<Job> getAllJobs(){
        return jobRepo.getAllJobs();
    }


    public Job getJob(int id){
        for(Job job:getAllJobs())
        {
            if (job.getId()==id)return job;
        }
        return null;
    }

    public Job updateJob(Job job) {
        return jobRepo.updateJob(job);
    }
}
