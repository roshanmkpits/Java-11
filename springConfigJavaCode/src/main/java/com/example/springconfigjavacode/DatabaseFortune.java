package com.example.springconfigjavacode;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortune implements FortuneService{
    @Override
    public String getFortuneService() {
        return "database fortune";
    }
}
