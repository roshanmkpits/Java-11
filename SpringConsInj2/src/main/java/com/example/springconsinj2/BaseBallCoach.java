package com.example.springconsinj2;

public class BaseBallCoach implements Coach{

    private FortuneService fortuneService;
    BaseBallCoach(FortuneService fortuneServic){
        this.fortuneService=fortuneServic;
    }
    @Override
    public String getDailyWorkout() {
        return "practice batting 30 min ";
    }

    @Override
    public String getFortune() {
        return "have a good day today";
    }
}
