package com.example.springinjvaluepropfile;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("com.example.springinjvaluepropfile")
@PropertySource("classpath:sport.properties")
public class MyAppConfig {

    @Bean
    public Student1 sob(){
        Student1 obj=new Student1();
        return obj;
    }
}
