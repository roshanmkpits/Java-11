//Write a method named hasSharedDigit with two parameters of type int.
//
//        Each number should be within the range of 10 (inclusive) - 99 (inclusive). If one of the numbers is not within the range, the method should return false.
//
//        The method should return true if there is a digit that appears in both numbers, such as 2 in 12 and 23; otherwise, the method should return false.
public class challange5SharedDigit {
    public static boolean hasSharedDigit (int num1, int num2) {
        if (num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) {
            return false;
        }

        int compare1 = 0;
        int compare2 = 0;
        while (num1 > 0) {
            compare1 = num1 % 10;
            num1 /= 10;
            int originalNum2 = num2;
            while (originalNum2 > 0) {
                compare2 = originalNum2 % 10;
                originalNum2 /= 10;
                if (compare1 == compare2) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(126,326));
    }
}
