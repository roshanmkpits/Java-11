package ioc2.coach2;
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

public class Myapp2 {
    public static void main(String[] args) {
      Coach coach=new BaseballCoach();
        System.out.println(coach.getDailyWorkout());

        Coach coach2=new TrackCoach();
        System.out.println(coach2.getDailyWorkout());
    }
}


//praactice 30 min batting
//        run 5k daily