package com.aranna.java11_project_job_portal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aranna.java11_project_job_portal.model.JobPost;
import com.aranna.java11_project_job_portal.repository.JobRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
    
    @RequestMapping({"/","home"})
    public ModelAndView getHome(ModelAndView mv){
        mv.setViewName("home");
        try {
        System.out.println("getHome method called.");
        System.out.println(JobRepository.jobList);
        List<JobPost> jp=JobRepository.jobList;
        mv.addObject("jp", jp);
        System.out.println(jp);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return mv;
    }

    @RequestMapping("addJob")
    public String addJob(HttpServletRequest req){
        try {
            JobPost jp=new JobPost();
            jp.setPostId(0);
            jp.setPostProfile(req.getParameter("profile"));
            jp.setPostDescription(req.getParameter("desc"));
            jp.setPostTechStack(Arrays.asList(req.getParameter("techs")));
            jp.setReqExperience(Integer.parseInt(req.getParameter("exp")));
            JobRepository.jobList.add(jp);
            System.out.println("added successfully.");
            System.out.println(jp+""+JobRepository.jobList);
        
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return "addJob";

    }
}
