package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.jwt;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.repo.UserRepo;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class SecurityConfiguration {

    // securityFilterchain
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                customizer -> customizer
                        // .requestMatchers("/**")
                        // .permitAll()
                        .anyRequest()
                        .authenticated())
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(customizer -> customizer.disable())
                // .csrf(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .formLogin(customizer -> customizer.disable())
                .headers(customizer -> customizer.frameOptions(frame -> frame.sameOrigin()))
                .build();
    }

    // for h2
    // @Bean
    // public UserDetailsService userDetailsService(javax.sql.DataSource
    // dataSource){
    // var user=User.builder().username("user")
    // // .password("{noop}password")
    // .password("password")
    // .passwordEncoder(str->bCryptPasswordEncoder().encode(str))
    // .roles("USER")
    // .build();
    // var jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
    // jdbcUserDetailsManager.createUser(user);
    // return jdbcUserDetailsManager;
    // }

    // for h2
    // @Bean
    // public javax.sql.DataSource dataSource(){
    // return new EmbeddedDatabaseBuilder()
    // .setType(EmbeddedDatabaseType.H2)
    // .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
    // .build();
    // }

    @Bean
    public UserDetailsService userDetailsService(UserRepo userRepo) {
        return username -> userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    @Bean
    public CommandLineRunner initData(UserRepo userRepo) {
        return args -> {
            if (userRepo.findByUsername("user").isEmpty()) {
                com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.model.User user = new com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.model.User();
                user.setUsername("user");
                user.setPassword(bCryptPasswordEncoder().encode("password"));
                user.setRole("ROLE_USER");
                userRepo.save(user);
                log.info("Default user created in PostgreSQL");
            }
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
