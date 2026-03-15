package com.aranna.java20_spring_jwt_using_nimbus_jose.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.aranna.java20_spring_jwt_using_nimbus_jose.repo.UserRepo;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserRepo userRepo;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return httpSecurity.authorizeHttpRequests(
                customizer -> customizer
                .requestMatchers("/**")
                .permitAll()
                // .anyRequest()
                // .authenticated()
                )
                .csrf(customizer->customizer.disable())
                .formLogin(customizer -> customizer.disable())
                .httpBasic(customizer->customizer.disable())
                .sessionManagement(customizer->customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        var user1=User.builder()
        .username("user1")
        .password(passwordEncoder().encode("password"))
        .roles("USER")
        .build();
        var user2=User.builder()
        .username("user2")
        .password(passwordEncoder().encode("password"))
        .roles("USER")
        .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }


    @Bean
    public AuthenticationManager authenticationManager(){
        var authenticationProvider=new DaoAuthenticationProvider(userDetailsService());;
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authenticationProvider);
    }
}
