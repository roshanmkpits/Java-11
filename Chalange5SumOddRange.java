//Write a method called isOdd with an int parameter and call it number. The method needs to return a boolean.
//
//        Check that number is > 0, if it is not return false.
//
//        If number is odd return true, otherwise return false.
//
//        Write a second method called sumOdd that has 2 int parameters start and end, which represent a range of numbers.
public class Chalange5SumOddRange {
    public static boolean isOdd (int number) {
        if (number < 0) {
            return false;
        }
        if (number % 2 == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int sumOdd (int start, int end) {
        int sum = 0;
        if ((start <= end) && (start > 0) && (end > 0)) {
            for (int i = start; i <= end; i++) {
                if (isOdd(i) == true) {
                    sum = sum+ i;
                }
            }
        }
        else {
            return -1;
        }
        return sum;
    }
    public static void main(String[] args) {

        System.out.println(sumOdd(1, 100));
        System.out.println(sumOdd(-1, 100));
        System.out.println(sumOdd(100, 100));
        System.out.println(sumOdd(13, 13));


    }
}
