package com.example.springmethodinjautowire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringMethodinjAutowireApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        CricketCoach ob=applicationContext.getBean("cricketCoach",CricketCoach.class);
        System.out.println(ob.getDailyWorkout());
        System.out.println(ob.getFortune());

    }

}
