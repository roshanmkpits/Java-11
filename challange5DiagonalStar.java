//Diagonal Star
//        Write a method named printSquareStar with one parameter of type int named number.
//
//        If number is < 5, the method should print "Invalid Value".
public class challange5DiagonalStar {

    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        }
        else {
            for (int i = 1; i <= number; i++) {
                for (int j = 1; j <= number; j++)
                    if (i == 1 || i == number) {
                        System.out.print("*");
                    }
                    else if (j == 1 || j == number) {
                        System.out.print("*");
                    }
                    else if (j == i) {
                        System.out.print("*");
                    }
                    else if (j == number - i + 1) {
                        System.out.print ( "*" );
                    }
                    else {
                        System.out.print(" ");
                    }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        printSquareStar(6);
    }
}
