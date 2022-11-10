package com.example.springsettrinj;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "have a good day";
    }
}
