package com.example.springqualifiersprob;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomFortune implements FortuneService{

    @Override
    public String getFortuneService() {
        return "random fortune";
    }
}
