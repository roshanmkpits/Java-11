package arrayexecise;
//
//Find the missing number in an integer array of 1 to 10.
//
//        Example for 10 elements
//
//        int intArray[] = {1, 2, 3, 4, 5, 6, 8, 9, 10};
//        missingNumber(intArray); // 7
//equation  n(n+1)/2
public class MissingNumberArray {
    public static void main(String[] args) {

        int intArray[] = {1, 2, 3, 4, 5, 6,7, 8, 10};
        int sum1=0;
        int sum2=0;

        for (int i = 0; i < intArray.length; i++) {
            sum2+=intArray[i];
            }
        sum1=10*(10+1)/2;
        System.out.println("missing number  "+Math.abs(sum2-sum1));

    }
}
//    missing number  9