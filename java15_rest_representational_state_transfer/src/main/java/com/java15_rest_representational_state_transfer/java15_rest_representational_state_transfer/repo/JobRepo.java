package com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.model.JobPost;

@Repository
public class JobRepo {
    List<JobPost> jobPosts=new ArrayList<>();
    public List<JobPost> getJobPosts() {
        return jobPosts;
    }
    public JobPost getJobPost(int postId){
        for (JobPost  jobPost:jobPosts){
            if(jobPost.getPostId()==postId){
                return jobPost;
            }
        }
        return null;
    }
    public void addJob(JobPost jobPost) {
        jobPosts.add(jobPost);
    }
    public JobRepo(){
        jobPosts.add(new JobPost(101,"Jr. RUST Developer","Actix,Rocket,Yew Framework, Applications Development and Deployment",2,List.of("Yew","Rocket","Actix")));
        jobPosts.add(new JobPost(102,"Sr. RUST Developer","Actix,Rocket,Yew, Leptos,Sycamore,Trunk Framework Applications Development and Deployment",2,List.of("Yew","Rocket","Actix","Scamore","Leptos")));
        jobPosts.add(new JobPost(103,"Sr Java Developer","JPA,Hibernate,Spring,Spring Boot",3,List.of("Spring Boot", "Gen AI")));

    }
}
