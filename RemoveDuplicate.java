package array13;
//Duplicate Number
//        Write a function to find the duplicate number on given integer array.
//
//        Example
//
//        removeDuplicates({1, 1, 2, 2, 3, 4, 5})
//        Output : [1, 2, 3, 4, 5]

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        RemoveDuplicate duplicate=new RemoveDuplicate();
        int att[]={1, 1, 2, 2, 3, 4, 5};
       int res[]= duplicate.removeDuplicates(att);
        System.out.println(Arrays.toString(res));
    }
    public int removeDuplicates(int a[], int n) {

        if (n == 0 || n == 1) {

            return n;

        }

        int j = 0;

        for (int i = 0; i < n - 1; i++) {

            if (a[i] != a[i + 1]) {

                a[j++] = a[i];

            }

        }

        a[j++] = a[n - 1];

        return j;

    }



    public  int[] removeDuplicates(int[] arr) {

        int result = removeDuplicates(arr, arr.length);

        int[] newArray = new int[result];

        for (int i = 0; i < result; i++) {

            newArray[i] = arr[i];

        }

        return newArray;

    }


}

//output
//[1, 2, 3, 4, 5]