public class Chalange5NumberPalindrome {

    public static boolean isPalindrome (int number) {
        int posNumber = Math.abs(number);

        String num1 = "";
        num1 += posNumber;
        String num2 = "";

        int reverse = 0;
        int lastDigit = 0;
        while (posNumber > 0) {
            lastDigit = posNumber % 10;
            posNumber /= 10;
            num2 += lastDigit;
        }

        if (num1.equals(num2)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(123));

    }
}
