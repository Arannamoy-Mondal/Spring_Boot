package com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.model.JobPost;
import com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.repo.JobRepo;

@Service
public class JobService {
    @Autowired
    public JobRepo jobRepo;

    public List<JobPost> getJobRepos() {
        return jobRepo.getJobPosts();
    }

    public void addJob(JobPost job) {
        jobRepo.addJob(job);
    }

    public JobPost getJobRepo(int postId) {
        return jobRepo.getJobPost(postId);
    }

}
