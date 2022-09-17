//Perfect Number
//        What is the perfect number?
//        A perfect number is a positive integer which is equal to the sum of its proper positive divisors.
//        Proper positive divisors are positive integers that fully divide the perfect number without leaving a remainder and exclude the perfect number itself.
//        For example, take the number 6:
//        Its proper divisors are 1, 2, and 3 (since 6 is the value of the perfect number, it is excluded), and the sum of its proper divisors is 1 + 2 + 3 = 6.
public class Challange5PerfectNumber {

    public static boolean isPerfectNumber(int number) {
        if (number == 0) {
            return false;
        }

        int sum = 0;

        for (int i=1; i<number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        if (sum == number) {
            return true;
        }
        else {
            return false;
        }

    }
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
    }
}
