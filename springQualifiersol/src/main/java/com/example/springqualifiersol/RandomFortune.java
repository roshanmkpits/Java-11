package com.example.springqualifiersol;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortune implements FortuneService{

    String msg[]={
            "goody day for you",
            "better luck today ",
            "better to leave "
    };

     private Random random=new Random();
    @Override
    public String getFortuneService() {
        int index=random.nextInt(msg.length);
        String fortune=msg[index];
        return fortune;
    }
}
