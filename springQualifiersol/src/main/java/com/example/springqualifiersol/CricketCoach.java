package com.example.springqualifiersol;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
public class CricketCoach implements Coach{
    @Autowired
    @Qualifier("randomFortune")
   private  FortuneService fortuneService;




    @Override
    public String getDailyWorkout() {
        return "throw fast ball daily 5 min ";
    }

    @Override
    public String getFortune() {
        System.out.println(fortuneService.getFortuneService());
        return " your cricket journey remain good  ";
    }



}
