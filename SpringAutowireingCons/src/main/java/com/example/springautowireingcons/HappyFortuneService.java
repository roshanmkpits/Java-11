package com.example.springautowireingcons;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortuneService() {
        return "today is luck day";
    }
}
