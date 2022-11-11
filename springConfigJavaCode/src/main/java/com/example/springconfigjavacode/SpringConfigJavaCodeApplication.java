package com.example.springconfigjavacode;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigJavaCodeApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SportConfig.class);
        CricketCoach ob=applicationContext.getBean("cricketCoach",CricketCoach.class);
        System.out.println(ob.getDailyWorkout());
        System.out.println(ob.getFortune());

    }

}
