//Write a method named getGreatestCommonDivisor with two parameters of type int named first and second.
//
//        If one of the parameters is < 10, the method should return -1 to indicate an invalid value.
//
//        The method should return the greatest common divisor of the two numbers (int).
//
//        The greatest common divisor is the largest positive integer that can fully divide each of the integers (i.e. without leaving a remainder).

public class Chalange5GreatestCommonDiviso {

    public static int getGreatestCommonDivisor (int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }

        int GCD = 1;
        int firstHolder = first;
        int secondHolder = second;

        if (first < second) {
            for (int i = 1; i<first+1; i++) {
                if (firstHolder % i == 0 && secondHolder % i == 0) {
                    GCD = i;
                }
            }
        }
        else {
            for (int i = 1; i<second+1; i++) {
                if (firstHolder % i == 0 && secondHolder % i == 0) {
                    GCD = i;
                }
            }
        }
        return GCD;
    }
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(30,12));
    }
}
