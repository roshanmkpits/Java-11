package com.example.springqualifiersprob;


import org.springframework.context.support.ClassPathXmlApplicationContext;

//creating multiple implementation of fortune interface
//which create error
public class SpringQualifiersprobApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        Coach ob= (Coach) applicationContext.getBean("cricketCoach");
        System.out.println(ob.getDailyWorkout());
        System.out.println(ob.getFortune());

    }

}
//    No qualifying bean of type 'com.example.springqualifiersprob.FortuneService' available: expected single matching bean but found 2: happyFortuneService,randomFortune