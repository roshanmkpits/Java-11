package com.example.springautowireingcons;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAutowireingConsApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
		CricketCoach ob=applicationContext.getBean("cricketCoach",CricketCoach.class);
		System.out.println(ob.getDailyWorkout());
		System.out.println(ob.getFortune());
	}

}
