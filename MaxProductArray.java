package arrayexecise;
//How to find maximum product of two integers in the array where all elements are positive.
//
//        Example
//
//        int[] intArray = {10,20,30,40,50};
//        maxProduct(intArray) // (40,50)
public class MaxProductArray {
    public static void main(String[] args) {
        MaxProductArray array=new MaxProductArray();
        int[] intArray = {10,20,30,40,50};
        String pair=array.maxProdut(intArray);
        System.out.println(pair);

    }

    public String maxProdut(int arr[]){
        int max=0;
        String pair="";
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]*arr[j]>max){
                    max=arr[i]*arr[j];
                    pair=Integer.toString(arr[i])+","+Integer.toString(arr[j]);
                }

            }

        }
        return pair;

    }
}


//output 40 , 50