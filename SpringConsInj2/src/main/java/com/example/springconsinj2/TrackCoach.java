package com.example.springconsinj2;

public class TrackCoach implements Coach{
    private  HappyFortuneService fortuneService;
    public TrackCoach(HappyFortuneService fortuneService) {
      this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "run daily 3 km ";
    }

    @Override
    public String getFortune() {
        return "running is good ";
    }
}
