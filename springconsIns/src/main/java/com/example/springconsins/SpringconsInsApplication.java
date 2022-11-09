package com.example.springconsins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringconsInsApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        Coach ob= (Coach) applicationContext.getBean("bob");
        System.out.println(ob.getDailyWorkout());
        System.out.println(ob.getFortune());
    }

}
