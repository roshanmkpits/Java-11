class MinutesToYearsDaysCalculator {
    // write your code here
    public static void printYearsAndDays(long minutes ) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            long years = (minutes / (365 * 24 * 60));
            long remainingDays = ((minutes / (60 * 24)) % 365);
            System.out.println(minutes + " min = " + years + " y and " + remainingDays + " d ");
        }
    }
}
public class ChallangeMinuteToYearDay {
    public static void main(String[] args) {
     MinutesToYearsDaysCalculator.printYearsAndDays(525600);
    }
}
