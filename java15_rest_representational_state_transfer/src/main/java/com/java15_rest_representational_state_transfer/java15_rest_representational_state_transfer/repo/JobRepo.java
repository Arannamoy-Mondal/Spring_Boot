package com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.model.JobPost;

@Repository
public class JobRepo {
    List<JobPost> jobPosts=new ArrayList<>();
    public JobRepo(){
        jobPosts.add(new JobPost(101,"Jr. RUST Developer","Actix,Rocket,Yew Framework, Applications Development and Deployment",2,List.of("YEW","Rocket","Actix")));
        jobPosts.add(new JobPost(102,"Sr. RUST Developer","Actix,Rocket,Yew, Leptos,Sycamore,Trunk Framework Applications Development and Deployment",2,List.of("YEW","Rocket","Actix","Scamore","Leptos")));

    }
}
