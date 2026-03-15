package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.jwt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.UUID;

// import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
// import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.model.User;
import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.repo.UserRepo;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class SecurityConfiguration {

    // securityFilterchain
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                customizer -> customizer
                        .requestMatchers("/user/signup")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(customizer -> customizer.disable())
                // .csrf(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .formLogin(customizer -> customizer.disable())
                .headers(customizer -> customizer.frameOptions(frame -> frame.sameOrigin()))
                .oauth2ResourceServer(customizer->customizer.jwt(Customizer.withDefaults()))
                .build();
    }


    // Outh2Server configuration start


    @Bean
    public KeyPair keyPair() throws Exception{
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(4096);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            log.info(e.getMessage());
            throw new Exception("Fault in keypair generator."+" "+getClass().descriptorString());
        }
    }


    @Bean
    RSAKey rsaKey(KeyPair keyPair){
        return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic()).privateKey(keyPair.getPrivate())
        .keyID(UUID.randomUUID().toString())
        .build();
    }


    @Bean
    JWKSource<SecurityContext> jwKSource(RSAKey rsaKey){
        var jwkSet= new JWKSet(rsaKey);
        return (jwkSelector,context)->jwkSelector.select(jwkSet);
    }



    @Bean
    public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException{
        return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey())
        .build();
    }


    @Bean

    JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource){
        return new NimbusJwtEncoder(jwkSource);
    }

    // Outh2Server configuration end










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

    // @Bean
    // public CommandLineRunner initData(UserRepo userRepo) {
    //     return new CommandLineRunner() {
    //     @Override
    //     public void run(String... args) {

    //         if (userRepo.findByUsername("user").isEmpty()) {

    //             User user = new User();
    //             user.setUsername("user");
    //             user.setPassword(bCryptPasswordEncoder().encode("password"));
    //             user.setRole("ROLE_USER");

    //             userRepo.save(user);

    //             log.info("Default user created in PostgreSQL");
    //         }
    //     }
    // };
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
