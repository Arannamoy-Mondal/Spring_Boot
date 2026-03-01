package com.java22_spring_g_rpc.java22_spring_g_rpc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.grpc.protobuf.services.ProtoReflectionService;

@Configuration
public class GrpcConfig {
    @Bean
    public ProtoReflectionService reflectionService() {
        return (ProtoReflectionService) ProtoReflectionService.newInstance();
    }
}
