package arrayexecise;
//Write a program to to check if an array contains a number in Java.
//
//        int[] intArray = {1,2,3,4,5,6};
//        searchInArray(intArray, 6); // 5
public class SearchInArray {
    public static void main(String[] args) {
        SearchInArray array=new SearchInArray();
        int[] intArray = {1,2,3,4,5,6};
        array.linearSearch(intArray,6);

    }
    public void linearSearch(int arr[],int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==value){
                System.out.println("value found at "+i);
                return;
            }

        }
        System.out.println("value not found ");
    }
}

//output
//value found at 5