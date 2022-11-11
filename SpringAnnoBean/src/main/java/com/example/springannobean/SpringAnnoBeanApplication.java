package com.example.springannobean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringAnnoBeanApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfigDemo.class);
        Student ob=applicationContext.getBean("sbean",Student.class);
        ob.display();

    }

}
