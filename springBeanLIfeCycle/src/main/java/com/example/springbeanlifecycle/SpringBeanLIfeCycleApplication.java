package com.example.springbeanlifecycle;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanLIfeCycleApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        CricketCoach ob=applicationContext.getBean("cob",CricketCoach.class);
        System.out.println(ob.getDailyWorkout());
        applicationContext.close();


    }

}
