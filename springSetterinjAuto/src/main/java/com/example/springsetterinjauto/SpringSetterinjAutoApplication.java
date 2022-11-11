package com.example.springsetterinjauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringSetterinjAutoApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        CricketCoach ob=applicationContext.getBean("cricketCoach",CricketCoach.class);
        System.out.println(ob.getDailyWorkout());
        System.out.println(ob.getFortune());

    }

}
