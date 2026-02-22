package com.java17_spring_aop.java17_spring_aop.aop;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.java17_spring_aop.java17_spring_aop.service..*(..))")
    public void callLogmethodBefore(JoinPoint jp) {
        LOGGER.info("\n############### Method called "+jp.getSignature().getName()+" ###############");
    }

    @After("execution(* com.java17_spring_aop.java17_spring_aop.service..*(..))")
    public void callLogmethodAfter(JoinPoint jp) {
        LOGGER.info("\n############### Method executed "+jp.getSignature().getName()+" ###############");
    }


    @AfterThrowing("execution(* com.java17_spring_aop.java17_spring_aop.service..*(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("\n############### Method has some issue  "+jp.getSignature().getName()+" ###############");
    }


    @AfterReturning("execution(* com.java17_spring_aop.java17_spring_aop.service..*(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("\n############### Method Executed Successfully. "+jp.getSignature().getName()+" ###############");
    }
}
