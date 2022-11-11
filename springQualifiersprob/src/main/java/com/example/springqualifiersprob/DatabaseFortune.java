package com.example.springqualifiersprob;

import org.springframework.stereotype.Component;


public class DatabaseFortune implements FortuneService{
    @Override
    public String getFortuneService() {
        return "database fortune";
    }
}
