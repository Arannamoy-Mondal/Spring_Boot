package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    // securityFilterchain
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests(
            customizer->
            customizer
            // .requestMatchers("/**")
            // .permitAll()
            .anyRequest()
            .authenticated()
        )
        .sessionManagement(customizer->customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf(customizer->customizer.disable())
        // .csrf(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults())
        .formLogin(customizer->customizer.disable())
        .headers(customizer->customizer.frameOptions().sameOrigin())
        .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        var user=User.builder().username("user")
        .password("{noop}password")
        // .passwordEncoder(null)
        .roles("USER")
        .build();
        return new InMemoryUserDetailsManager(user);
    }

}
