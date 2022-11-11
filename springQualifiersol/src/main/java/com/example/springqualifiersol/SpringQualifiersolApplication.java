package com.example.springqualifiersol;


import org.springframework.context.support.ClassPathXmlApplicationContext;


//use of Qualifiers annotation
//random fortune 
public class SpringQualifiersolApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        Coach ob= (Coach) applicationContext.getBean("cricketCoach");
        System.out.println(ob.getDailyWorkout());
        System.out.println(ob.getFortune());

    }

}
//throw fast ball daily 5 min
//        better luck today
//        your cricket journey remain good