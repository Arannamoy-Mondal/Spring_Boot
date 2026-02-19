package com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.model.JobPost;
import com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer.repo.JobRepo;

@Service
public class JobService {
    @Autowired
    public JobRepo jobRepo;

    public List<JobPost> getJobRepos() {
        return jobRepo.findAll();
    }

    public String addJob(JobPost job) {
        jobRepo.save(job);
        return "Successfully added.";
    }
    public JobPost updatJobRepo(JobPost jobPost){
        return jobRepo.save(jobPost);
    }

    public String delJobPost(int postId){
        jobRepo.deleteById(postId);
        return "Successfully deleted.";
    }

    public Optional<JobPost> getJobRepo(int postId) {
        Optional<JobPost> res=jobRepo.findById(postId);
        return res;
    }


    public String load(){
        List<JobPost> jobPosts = new ArrayList<>();
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

        jobRepo.saveAll(jobPosts);
        return "Successfully loaded";
    }

}
