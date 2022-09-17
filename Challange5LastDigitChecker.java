//Write a method named hasSameLastDigit with three parameters of type int.
//
//        Each number should be within the range of 10 (inclusive) - 1000 (inclusive). If one of the numbers is not within the range, the method should return false.
//
//        The method should return true if at least two of the numbers share the same rightmost digit; otherwise, it should return false.

public class Challange5LastDigitChecker {
    public static boolean hasSameLastDigit (int num1, int num2, int num3) {
        if (num1 < 10 || num1 > 1000 || num2 < 10 || num2 > 1000 || num3 < 10 || num3 > 1000) {
            return false;
        }

        int compare1 = 0;
        int compare2 = 0;
        int compare3 = 0;
        while (num1 > 0) {
            compare1 = num1 % 10;
            num1 /= 10;
            break;
        }
        while (num2 > 0) {
            compare2 = num2 % 10;
            num2 /= 10;
            break;
        }
        while (num3 > 0) {
            compare3 = num3 % 10;
            num3 /= 10;
            break;
        }
        if (compare1 == compare2 || compare2 == compare3 || compare1 == compare3) {
            return true;
        }
        return false;
    }

    public static boolean isValid (int num1)
    {
        if(num1 >= 10 && num1 <= 1000)
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(12,24,52));
        System.out.println(isValid(200));
    }
}
