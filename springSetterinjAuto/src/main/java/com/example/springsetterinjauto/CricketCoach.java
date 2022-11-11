package com.example.springsetterinjauto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class CricketCoach implements Coach{

   private  HappyFortuneService fortuneService;

      @Autowired
    public void setFortuneService(HappyFortuneService fortuneService) {
        System.out.println("setfortune method called ");
        this.fortuneService = fortuneService;
    }

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
