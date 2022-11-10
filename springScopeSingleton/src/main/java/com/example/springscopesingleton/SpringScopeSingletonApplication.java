package com.example.springscopesingleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringScopeSingletonApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext  applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        CricketCoach ob=applicationContext.getBean("cob",CricketCoach.class);

        CricketCoach ob2=applicationContext.getBean("cob",CricketCoach.class);
        System.out.println("ob  "+ob);
        System.out.println("ob2  "+ob2);

        boolean st=(ob==ob2);
        if(st){
            System.out.println("equal ");
        }
        else {
            System.out.println("not equal ");
        }
    }

}


//output
//ob  com.example.springscopesingleton.CricketCoach@6ca18a14
//        ob2  com.example.springscopesingleton.CricketCoach@6ca18a14
//        equal