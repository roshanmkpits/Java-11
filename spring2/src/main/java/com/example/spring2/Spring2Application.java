package com.example.spring2;


import org.springframework.context.support.ClassPathXmlApplicationContext;

//creating beans
//implementing ioc
public class Spring2Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        Coach ob= (Coach) applicationContext.getBean("one");
        System.out.println(ob.getDailyWorkout());
    }

}
