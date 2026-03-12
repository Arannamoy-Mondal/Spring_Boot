package com.aranna.java20_spring_jwt_v2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BasicAuthSecurity {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity.authorizeHttpRequests(customizer->
            customizer
            // .requestMatchers("/**")
            // .permitAll()
            .anyRequest()
            .authenticated()
        )
        .csrf(customizer->customizer.disable())
        .formLogin(customizer->customizer.disable())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(customizer->customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    }
}
