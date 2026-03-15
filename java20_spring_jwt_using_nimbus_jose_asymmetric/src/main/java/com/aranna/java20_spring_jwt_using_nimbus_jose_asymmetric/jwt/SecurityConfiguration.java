package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests(
            customizer->
            customizer
            .anyRequest()
            .authenticated()
        )
        .sessionManagement(customizer->customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf(customizer->customizer.disable())
        .httpBasic(Customizer.withDefaults())
        .formLogin(customizer->customizer.disable())
        .build();
    }
}
