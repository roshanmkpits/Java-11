package com.example.springmethodinjautowire;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortuneService() {
        return "today is luck day";
    }
}
