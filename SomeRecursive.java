import java.util.Arrays;
//
//Write a recursive function called someRecursive which accepts an array and a callback. The function returns true if a single value in the array returns true when passed to the callback. Otherwise it returns false.
//
//        Examples
//
//        someRecursive({1,2,3,4}, isOdd) # true
//        someRecursive({4,6,8,9}, isOdd) # true
//        someRecursive({4,6,8}, isOdd) # false
//


public class SomeRecursive {
    public static void main(String[] args) {

        SomeRecursive recursive=new SomeRecursive();
        OddFunction isodd=new OddFunction();
        boolean rec=recursive.someRecursive(new int[]{1, 2, 3, 4},isodd);

        System.out.println(rec);
        boolean rec1=recursive.someRecursive(new int[]{4, 6, 8}, isodd);
        System.out.println(rec1);

    }

    public boolean someRecursive(int[] arr, OddFunction odd) {
        if (arr.length == 0 ) {
            return false;
        } else if (odd.run(arr[0]) == false) {
            return someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
        } else {
            return true;
        }
    }

    public static class OddFunction {
        static boolean run(int num) {
            if (num % 2 == 0) {
                return false; }
            else {
                return true;
            }
        }
    }
}

//output
// true
//false