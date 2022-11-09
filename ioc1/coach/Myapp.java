package ioc1.coach;

class BaseballCoach{
    public String getDailyWorkout(){
        return "praactice 30 min batting ";
    }
}

public class Myapp {
    public static void main(String[] args) {
      BaseballCoach coach=new BaseballCoach();
        System.out.println(coach.getDailyWorkout());
    }
}


//praactice 30 min batting