package com.example.spring2;
interface Coach{
    public String getDailyWorkout();

}
class BaseballCoach implements Coach{
    public String getDailyWorkout(){
        return "praactice 30 min batting ";
    }
}
class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "run 5k daily";
    }
}
public class Hellow {
    void display(){
        System.out.println("hellow beans ");
    }
}
