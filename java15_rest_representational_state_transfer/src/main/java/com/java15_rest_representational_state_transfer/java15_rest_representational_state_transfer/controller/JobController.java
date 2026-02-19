package com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.model.JobPost;
import com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController 
@CrossOrigin(origins = "0.0.0.0:5000")
public class JobController {
    @Autowired
    public JobService jobService;

    public JobService getJobService() {
        return jobService;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping("/api/v1/jobs")
    @ResponseBody
    public List<JobPost> getAllJobs(){
            return jobService.getJobRepos();
       
    }


    @GetMapping("/api/v1/job")
    @ResponseBody
    public JobPost getJob(@RequestParam int postId) {
        System.out.println(postId);
        return jobService.getJobRepo(postId);
    }

    @PostMapping("/api/v1/job")
    public JobPost postJob(@RequestBody JobPost jobPost) {
        System.out.println(jobPost);
        jobService.addJob(jobPost);
        return jobService.getJobRepo(jobPost.getPostId());
    }
    @PutMapping("/api/v1/job")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        System.out.println(jobPost);
        return jobService.updatJobRepo(jobPost);
    }

    @DeleteMapping("/api/v1/job/{postId}")
    public JobPost deleJobPost(@PathVariable int postId){
        return jobService.delJobPost(postId);
    }


    @GetMapping(path="/api/v1/jobs/json",produces = "application/json")
    public List<JobPost> content_negotiation(){
        return jobService.getJobRepos();
    }
    
}
