package dec12arrayproj;

import java.util.Scanner;

//Calculate Average Temperature
// Find the Days Above Average Temperature
//with data structure array
public class ArrayProj2Tem {
    public static void main(String[] args) {
        System.out.println("How Many Days Temperature");
        Scanner scanner=new Scanner(System.in);
        int numOfdays=scanner.nextInt();
        int []temps=new int[numOfdays];
        int sum=0;
        for (int i = 0; i < numOfdays; i++) {
            System.out.println("Days " +(i+1)+ "High tempreature : ");
            temps[i]=scanner.nextInt();
            sum+=temps[i];
        }
        int average=sum/numOfdays;
        //count Days above average
        int above=0;
        for(int i=0;i<temps.length;i++) {
            if(temps[i]>average) {
                above++;
            }
        }
        System.out.println("Average tempreature "+ average);
        System.out.println(above+ " Days above  tempreature ");

    }
}
//output
//How Many Days Temperature
//3
//        Days 1High tempreature :
//        5
//        Days 2High tempreature :
//        20
//        Days 3High tempreature :
//        25
//        Average tempreature 16
//        2 Days above  tempreature
