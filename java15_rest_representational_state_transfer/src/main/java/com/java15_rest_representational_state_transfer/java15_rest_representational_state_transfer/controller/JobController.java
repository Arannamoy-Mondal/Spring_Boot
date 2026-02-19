package com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.controller;

import java.util.List;
import java.util.Optional;

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
    public Optional<JobPost> getJob(@RequestParam int postId) {
        System.out.println(postId);
        return jobService.getJobRepo(postId);
    }

    @PostMapping("/api/v1/job")
    public String postJob(@RequestBody JobPost jobPost) {
        System.out.println(jobPost);
        return jobService.addJob(jobPost);
    }
    @PutMapping("/api/v1/job")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        System.out.println(jobPost);
        return jobService.updatJobRepo(jobPost);
    }

    @DeleteMapping("/api/v1/job/{postId}")
    public String deleJobPost(@PathVariable int postId){
        return jobService.delJobPost(postId);
    }


    @GetMapping("/api/v1/jobs/json")
    public List<JobPost> content_negotiation(){
        return jobService.getJobRepos();
    }
    

    @GetMapping("/api/v1/jobs/load")
    public String load() {
        return jobService.load();
    }
    

    @GetMapping("/api/v1/search_by_key_word/{keyword}")
    public List<JobPost> getMethodName(@PathVariable("keyword") String keyword) {
        return jobService.search(keyword);
        // return new String();
    }
    
}
