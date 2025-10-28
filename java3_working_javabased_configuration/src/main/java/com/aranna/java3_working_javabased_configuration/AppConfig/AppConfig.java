package com.aranna.java3_working_javabased_configuration.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;

import com.aranna.java3_working_javabased_configuration.Alien;
import com.aranna.java3_working_javabased_configuration.Laptop;


@Configuration
@ComponentScan("com.")
public class AppConfig {
    // @Bean(name = {"alien2","alien2","alien3","alien4"})
    // @Scope("prototype")
    // @Bean
    // public Alien alien(){
    //         Alien a1=new Alien();
    //         a1.setName("Alien One");
    //         a1.setL(laptop());
    //     return a1;
    // }
    // @Bean
    // public Laptop laptop(){
    //     return new Laptop();
    // }
    
}
