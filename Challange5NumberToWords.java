//Number To Words
//        Write a method called numberToWords with one int parameter named number.
//
//        The method should print out the passed number using words for the digits.
//
//        If the number is negative, print "Invalid Value".
//
//        To print the number as words, follow these steps:
//
//        Extract the last digit of the given number using the remainder operator.
//
//        Convert the value of the digit found in Step 1 into a word. There are 10 possible values for that digit, those being 0, 1, 2, 3, 4, 5, 6, 7, 8, 9. Print the corresponding word for each digit, e.g. print "Zero" if the digit is 0, "One" if the digit is 1, and so on.
//
//        Remove the last digit from the number.
//
//        Repeat Steps 2 through 4 until the number is 0.

public class Challange5NumberToWords {
    public static void numberToWords (int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }

        int countEnd = getDigitCount(number);
        int numMule;
        int count = 0;
        number = reverse(number);
        while (count < countEnd) {
            numMule = number % 10;
            number /= 10;
            count++;
            switch(numMule) {
                case 0:
                    System.out.print("Zero ");
                    break;
                case 1:
                    System.out.print("One ");
                    break;
                case 2:
                    System.out.print("Two ");
                    break;
                case 3:
                    System.out.print("Three ");
                    break;
                case 4:
                    System.out.print("Four ");
                    break;
                case 5:
                    System.out.print("Five ");
                    break;
                case 6:
                    System.out.print("Six ");
                    break;
                case 7:
                    System.out.print("Seven ");
                    break;
                case 8:
                    System.out.print("Eight ");
                    break;
                case 9:
                    System.out.print("Nine ");
                    break;
            }
        }
    }

    public static int reverse (int number) {
        int mule = 0;
        int numMule;
        boolean negNum = false;

        if (number < 0) {
            negNum = true;
            number = Math.abs(number);
        }

        while (number > 0) {
            numMule = number % 10;
            number /= 10;
            mule = Integer.valueOf(String.valueOf(mule) + String.valueOf(numMule));
        }

        if (negNum == true) {
            mule = mule * -1;
        }
        return mule;
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        else if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }

        return count;
    }
    public static void main(String[] args) {
     numberToWords(1234);
    }
}
