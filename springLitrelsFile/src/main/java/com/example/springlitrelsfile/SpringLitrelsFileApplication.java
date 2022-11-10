package com.example.springlitrelsfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringLitrelsFileApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        CricketCoach ob=applicationContext.getBean("cob",CricketCoach.class);
        System.out.println(ob.getName());
        System.out.println(ob.getEmail());

    }

}
