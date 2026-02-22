package com.java16_spring_data_rest.java16_spring_data_rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.java16_spring_data_rest.java16_spring_data_rest.model.JobPost;

@Repository
@RepositoryRestResource
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    
} 
