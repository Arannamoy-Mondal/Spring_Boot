package com.aranna.java12_rest_api_using_spring_boot.job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class JobRepository {
    public List<Job> jobList=new ArrayList<>(
        Arrays.asList(new Job(1,"Senior Java Developer","As a team lead.","4",Arrays.asList("Java", "Spring", "Next.Js","React.js")),
        new Job(2,"Junior Java Developer","Maintain java code, debugging.","0",Arrays.asList("Java", "Spring", "Next.Js","React.js")),
        new Job(3,"Quant Developer","Maintain quantconnect","0",Arrays.asList("Java", "Spring", "Quant Connect","Python","Next.Js","React.js")),
        new Job(4,"Data Scientist","","4",Arrays.asList("numpy","pandas","seaborn","matplotlib")),
        new Job(5,"ML Engineer","As a team lead.","4",Arrays.asList("Java", "Spring", "Next.Js","React.js", "Keras","Pytorch","Tensorflow","Spring AI","Python","Go")))

    );
    public void addJob(Job job){
        try {
        jobList.add(job);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public List<Job> getAllJobs(){
        return jobList;
    }

    public Job updateJob(Job job) {
        for(Job job1:jobList){
            if(job.getId()==job1.getId()){
                if(job.getJobProfile()!=null){
                    job1.setJobProfile(job.getJobProfile());
                }
                if(job.getJobDesc()!=null){
                    job1.setJobDesc(job.getJobDesc());
                }
                if(job.getExp()!=null){
                    job1.setExp(job.getExp());
                }
                if(job.getTechStack().size()>0){
                    job1.setTechStack(job.getTechStack());;
                }
                 return job1;
            }
        }
        return null;
    }
}
