package com.example.springsettrinj;


import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringSettrInjApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        Coach ob=  applicationContext.getBean("cob",Coach.class);
        System.out.println(ob.getDailyWorkout());
        System.out.println(ob.getFortune());
    }

}
