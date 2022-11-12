package com.example.springinjvaluepropfile;

import org.springframework.beans.factory.annotation.Value;


public class Student1 {
    @Value("${foo.name}")
    private String name;

    @Value("${foo.email}")
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void dispaly() {
        System.out.println("welcome to student life " + email + " name = " + name);
    }
}
