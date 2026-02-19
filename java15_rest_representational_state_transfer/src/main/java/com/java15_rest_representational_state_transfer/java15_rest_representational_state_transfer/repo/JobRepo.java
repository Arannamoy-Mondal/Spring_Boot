package com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc); 

    
} 


/*
 List<JobPost> jobPosts = new ArrayList<>();

    public List<JobPost> getJobPosts() {
        return jobPosts;
    }

    public JobPost getJobPost(int postId) {
        for (JobPost jobPost : jobPosts) {
            if (jobPost.getPostId() == postId) {
                return jobPost;
            }
        }
        return null;
    }

    public JobPost updateJobPost(JobPost updateJobPost_) {
        for (JobPost jobPost : jobPosts) {
            if (jobPost.getPostId() == updateJobPost_.getPostId()) {
                if (updateJobPost_.getPostDesc() != null) {
                    jobPost.setPostDesc(updateJobPost_.getPostDesc());
                }
                if (updateJobPost_.getPostProfile() != null) {
                    jobPost.setPostProfile(updateJobPost_.getPostProfile());
                }
                if (updateJobPost_.getReqExperience() != null) {
                    jobPost.setReqExperience(updateJobPost_.getReqExperience());
                }
                if (updateJobPost_.getPostTechStack() != null) {
                    jobPost.setPostTechStack(updateJobPost_.getPostTechStack());
                }

                return jobPost;
            }
        }
        return null;
    }

    public JobPost deleteJobPost(int postId){
        for (JobPost jobPost : jobPosts) {
            if (jobPost.getPostId() == postId) {
                jobPosts.remove(jobPost);
                return jobPost;
            }
        }
        return null;
    }
    public void addJob(JobPost jobPost) {
        jobPosts.add(jobPost);
    }

    public JobRepo() {
        jobPosts.add(new JobPost(101, "Jr. RUST Developer",
                "Actix,Rocket,Yew Framework, Applications Development and Deployment", 2,
                List.of("Yew", "Rocket", "Actix")));
        jobPosts.add(new JobPost(102, "Sr. RUST Developer",
                "Actix,Rocket,Yew, Leptos,Sycamore,Trunk Framework Applications Development and Deployment", 2,
                List.of("Yew", "Rocket", "Actix", "Scamore", "Leptos")));
        jobPosts.add(new JobPost(103, "Sr Java Developer", "JPA,Hibernate,Spring,Spring Boot", 3,
                List.of("Spring Boot", "Gen AI")));
        jobPosts.add(new JobPost(104, "ML Engineer (Rust)",
                "Rust, Linfa, ndarray, ONNX Runtime, Model Deployment, API Integration", 3,
                List.of("Rust", "Linfa", "ONNX", "Actix")));

        jobPosts.add(new JobPost(105, "AI Backend Developer (Go)",
                "Go, REST API, gRPC, Microservices, ML Model Serving, Kubernetes", 3,
                List.of("Go", "gRPC", "Docker", "Kubernetes")));

        jobPosts.add(new JobPost(106, "Deep Learning Engineer",
                "PyTorch, TensorFlow, CUDA, Model Optimization, Computer Vision", 4,
                List.of("PyTorch", "TensorFlow", "CUDA", "OpenCV")));

        jobPosts.add(new JobPost(107, "Rust AI Systems Engineer",
                "Actix, Tokio, Async Rust, Model Inference, High Performance Systems", 4,
                List.of("Rust", "Tokio", "Actix", "ONNX")));

        jobPosts.add(new JobPost(108, "Gen AI Engineer (Java)",
                "Spring Boot, LangChain4j, LLM Integration, Vector DB, RAG Pipeline", 3,
                List.of("Spring Boot", "LangChain4j", "LLM", "RAG")));

        jobPosts.add(new JobPost(109, "Go ML Infrastructure Engineer",
                "Go, MLOps, CI/CD, Model Monitoring, Prometheus, Docker", 3,
                List.of("Go", "MLOps", "Docker", "Prometheus")));

        jobPosts.add(
                new JobPost(110, "Computer Vision Engineer", "OpenCV, YOLO, CNN, Image Processing, Model Deployment", 3,
                        List.of("YOLO", "OpenCV", "PyTorch", "DL")));

        jobPosts.add(new JobPost(111, "AI Research Engineer",
                "Deep Learning, Transformers, NLP, LLM Fine-tuning, Research & Prototyping", 5,
                List.of("Transformers", "NLP", "LLM", "Research")));

        jobPosts.add(new JobPost(112, "Rust Blockchain + AI Developer",
                "Rust, Smart Contracts, AI Model Integration, Web3 API, WASM", 3,
                List.of("Rust", "WASM", "Web3", "AI")));

        jobPosts.add(
                new JobPost(113, "MLOps Engineer", "CI/CD, Docker, Kubernetes, MLflow, Model Deployment, Monitoring", 3,
                        List.of("MLOps", "MLflow", "Docker", "Kubernetes")));

        jobPosts.add(new JobPost(114, "Java AI Microservices Developer",
                "Spring Boot, REST APIs, Kafka, AI Model Serving, Cloud Deployment", 3,
                List.of("Spring Boot", "Kafka", "AI", "Cloud")));

        jobPosts.add(new JobPost(115, "Go Backend for AI Systems",
                "Go, Fiber, Gin, High Concurrency APIs, ML Model Integration", 2, List.of("Go", "Fiber", "Gin", "ML")));

    }

*/