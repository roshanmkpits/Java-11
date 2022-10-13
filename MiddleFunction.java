package array13;

import java.util.Arrays;

//Write a function called middle that takes a list and returns a new list that contains all but the first and last elements.
//
//        myArray = [1, 2, 3, 4]
//        middle(myArray)  # [2,3]
public class MiddleFunction {
    public static void main(String[] args) {
        MiddleFunction function=new MiddleFunction();
        int []myArray = {1, 2, 3, 4};
        int temp[]=function.middlefun(myArray);
        System.out.println(Arrays.toString(temp));
    }
    public int [] middlefun(int []arry)
    {
        return Arrays.copyOfRange(arry,1,arry.length-1);
    }
}

//output
// [2, 3]