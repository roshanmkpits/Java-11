
//Write a method named printFactors with one parameter of type int named number.
//
//        If number is < 1, the method should print "Invalid Value".
//
//        The method should print all factors of the number. A factor of a number is an integer which divides that number wholly (i.e. without leaving a remainder).
public class challange5FactorPrinter {

    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
        }
        for (int i=1; i<number+1; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        printFactors(30);
    }
}
