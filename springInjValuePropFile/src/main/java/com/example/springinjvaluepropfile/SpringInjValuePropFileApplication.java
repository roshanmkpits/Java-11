package com.example.springinjvaluepropfile;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringInjValuePropFileApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyAppConfig.class);
        Student1 student1=applicationContext.getBean("sob",Student1.class);
        student1.dispaly();
    }

}
