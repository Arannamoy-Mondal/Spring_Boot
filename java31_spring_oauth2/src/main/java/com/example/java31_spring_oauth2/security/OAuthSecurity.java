package com.example.java31_spring_oauth2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class OAuthSecurity {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity.authorizeHttpRequests(
            customizer->
            customizer.anyRequest().authenticated()
        )
        .formLogin(customizer->customizer.disable())
        .csrf(customizer->customizer.disable())
        .oauth2Login(Customizer.withDefaults())
        .build();
    }
}
