package array13;

//Missing Number
//        Write a function to find the missing number in a given integer array of 1 to 100.
//
//        Example
//
//        myArray = {1,2,3,4,6}
//        missingNumber(myArray, 6) // 5
public class Missingnum100 {
    public static void main(String[] args) {
        Missingnum100 missingnum100=new Missingnum100();
        int []myArray = {1,2,3,4,6};
       int res= missingnum100.missingNumber(myArray,6);
        System.out.println("missing number "+res);
    }
    public int missingNumber(int[] arr, int totalCount) {
        int expectedSum = 0;
        int actualSum = 0;
        for(int i = 1; i <= totalCount; ++i) {
            expectedSum += i;
        }
        for (int i=0; i<arr.length; i++) {
            actualSum += arr[i];

        }


        return expectedSum - actualSum;
    }
}

//output
//missing number 5