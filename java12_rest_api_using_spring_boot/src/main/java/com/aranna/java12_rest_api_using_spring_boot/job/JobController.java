package com.aranna.java12_rest_api_using_spring_boot.job;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class JobController {
    @Autowired
    public JobService jobService;

    @GetMapping("job")
    public List<Job> getAllJobs() {
        System.out.println(jobService.getAllJobs());
        return jobService.getAllJobs();
    }

    @GetMapping("job/{id}")
    public Job getJob(@PathVariable int id) {
        System.out.println("Id: " + id);
        return jobService.getJob(id);
    }

    @PostMapping("job")
    public List<Job> addJob(@RequestBody Job job) {
        System.out.println(job);
        jobService.addJob(job);
        return jobService.getAllJobs();
    }


    @PatchMapping("job")
    public List<Job> updateJob(@RequestBody Job job){
        jobService.updateJob(job);
        return jobService.getAllJobs();
    }
}
