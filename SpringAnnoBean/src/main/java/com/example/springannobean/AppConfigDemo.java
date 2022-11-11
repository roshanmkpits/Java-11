package com.example.springannobean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.springannobean")
public class AppConfigDemo {

    @Bean
    public Student sbean(){
        Student ob=new Student();
        return ob;
    }
}
