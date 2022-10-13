package array13;

//Your are given two integer arrays. Write a program to check if they are permutation of each other.
//
//        Example
//
//        int[] array1 = {1,2,3,4,5};
//        int[] array2 = {5,1,2,3,4};
//        permutation(array1, array2)

public class ArrayPermutation {
    public static void main(String[] args) {
        ArrayPermutation permutation=new ArrayPermutation();
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {5,1,2,3,4};
        boolean res=permutation.permutation(array1,array2);
        System.out.println(res);

    }
    public boolean permutation(int arry1[],int arry2[]){
        int sum1=0;
        int sum2=0;
        int mul1=1;
        int mul2=1;
        for (int i = 0; i < arry1.length; i++) {
            sum1+=arry1[i];
            mul1+=arry1[i];

        }
        for (int i = 0; i < arry2.length; i++) {
            sum2+=arry2[i];
            mul2+=arry2[i];
        }
        if(sum1==sum2 && mul1==mul2)
        {
            return true;
        }
        return false;
    }
}
//output
// true