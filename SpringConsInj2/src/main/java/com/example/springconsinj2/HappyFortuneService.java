package com.example.springconsinj2;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "have a good day";
    }
}
