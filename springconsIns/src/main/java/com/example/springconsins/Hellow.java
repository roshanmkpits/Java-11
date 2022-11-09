package com.example.springconsins;
interface Coach extends FortuneService{
    public String getDailyWorkout();

}
interface FortuneService{
    public String getFortune();
}

class HappyFortune implements FortuneService{

    @Override
    public String getFortune() {
        return "good luck for today ";
    }
}
class BaseballCoach implements Coach{
    public String getDailyWorkout(){
        return "praactice 30 min batting ";
    }

    @Override
    public String getFortune() {
        return "good day to you ";
    }
}
class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "run 5k daily";
    }

    @Override
    public String getFortune() {
        return "run hard for sucess";
    }
}
public class Hellow {
    void display(){
        System.out.println("hellow beans ");
    }
}
