package com.aranna.com.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
  
    // @CircuitBreaker(name = "sample-api", fallbackMethod = "hardCodedResponse") 
    // @RateLimiter(name = "default", fallbackMethod = "hardCodedResponse")
    @Bulkhead(name = "default")
    public String sampleApi() {
        logger.info("Sample api call received");
        
        return "Sample APi";
        // throw new RuntimeException("Fake Error");
    }

    public String hardCodedResponse(Exception ex) {
        logger.error("Fallback called because of: {}", ex.getMessage());
        return "fallback-response-after-retry";
    }
}