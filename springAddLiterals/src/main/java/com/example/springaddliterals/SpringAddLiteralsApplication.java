package com.example.springaddliterals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringAddLiteralsApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
       CricketCoach ob= applicationContext.getBean("cob",CricketCoach.class);
        System.out.println(ob.getEmail());
        System.out.println(ob.getName());

    }

}
