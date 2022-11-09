package com.example.springconsinj2;


import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringConsInj2Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        Coach ob= (Coach) applicationContext.getBean("bob");
        System.out.println(ob.getDailyWorkout());
        System.out.println(ob.getFortune());
    }

}
