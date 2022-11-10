package com.example.springbeanlifecycle;

public class CricketCoach implements Coach{

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getDailyWorkout() {
        return "throw fast ball daily 5 min ";
    }

    @Override
    public String getFortune() {
        return " your cricket journey remain good  ";
    }

    public  void onStart(){
        System.out.println(" before started ");
    }

    public  void onDestroy2(){
        System.out.println(" on destroyed  ");
    }
}
