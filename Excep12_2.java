import java.util.Scanner;

public class Excep12_2 {

    private static int divide() {
        int x = getInt();
        int y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        return s.nextInt();
    }
    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);

    }
}
//output
//Please enter an integer
//2
//        Please enter an integer
//        3
//        x is 2, y is 3
//        0
