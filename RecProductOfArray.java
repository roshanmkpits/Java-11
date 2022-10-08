
//Write a function called productOfArray which takes in an array of numbers and returns the product of them all.
//
//        Examples
//
//        int arr[] = { 1, 2, 3, 4, 5 };
//        productofArray(arr, arr.length); #120

public class RecProductOfArray {
    public static void main(String[] args) {
        RecProductOfArray array=new RecProductOfArray();
        int arr[] = { 1, 2, 3, 4, 5 };
        int rec=array.productofArray(arr,arr.length);
        System.out.println(rec);

    }

    public int productofArray(int A[], int N)
    {
        if (N <= 0)
            return 1;
        return (productofArray(A, N - 1) * A[N - 1]);
    }
}
//output
// 120