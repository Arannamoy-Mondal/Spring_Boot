package com.java17_spring_aop.java17_spring_aop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.java17_spring_aop.java17_spring_aop.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
    @Query("Select p from JobPost p")
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String jobPostProfile, String jobPostDesc);
}
