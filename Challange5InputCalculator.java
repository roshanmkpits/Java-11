import java.util.Scanner;

public class Challange5InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int counter = 0;

        while(true) {
            boolean input = scanner.hasNextInt();
            if (input) {
                int inputInt = scanner.nextInt();
                sum += inputInt;
                counter++;
            }
            else {
                double average = (double) sum / counter;
                System.out.println("SUM = " + sum + " AVG = " + Math.round(average));
                break;
            }
            scanner.nextLine();
        }
        scanner.close();
    }
    public static void main(String[] args) {

        inputThenPrintSumAndAverage();

    }
}
