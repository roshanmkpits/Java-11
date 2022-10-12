package dec12arrayproj;

import java.util.Scanner;
//Calculate Average Temperature
public class ArrayProj1Tem {
    public static void main(String[] args) {
        System.out.println("How Many Days Temperature");
        Scanner scanner=new Scanner(System.in);
        int numOfdays=scanner.nextInt();
        int sum=0;
        for (int i = 1; i <= numOfdays; i++) {
            System.out.println("Days " +i+ "High tempreature : ");
            int temp=scanner.nextInt();
            sum+=temp;
        }
        int average=sum/numOfdays;
        System.out.println("Average tempreature "+ average);

    }
}
//output
//    How Many Days Temperature
//3
//        Days 1High tempreature :
//        5
//        Days 2High tempreature :
//        20
//        Days 3High tempreature :
//        25
//        Average tempreature 16
