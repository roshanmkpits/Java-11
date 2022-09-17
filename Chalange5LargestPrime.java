//Write a method named getLargestPrime with one parameter of type int named number.
//
//        If the number is negative or does not have any prime numbers, the method should return -1 to indicate an invalid value.
//
//
//
//        The method should calculate the largest prime factor of a given number and return it.

public class Chalange5LargestPrime {
    public static int getLargestPrime(int number) {
        if (number <= 1) {
            return -1;
        }
        for (int i = 2; i < number; i++) {
            while (number % i == 0) {
                number = number / i;
                if (number == 2) {
                    i++;
                }
            }
        }
        return number;
    }
    public static void main(String[] args) {
        System.out.println(getLargestPrime(217));
    }
}
