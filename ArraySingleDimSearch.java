public class ArraySingleDimSearch {
    int arr[]=null;

    public ArraySingleDimSearch(int arraySize) {
        arr=new int[arraySize];
        for (int i=0;i<arr.length;i++){
            arr[i]=Integer.MIN_VALUE;
        }
    }

    public void insert(int location,int valueToBeInserted){
        try {
            if(arr[location]==Integer.MIN_VALUE){
                arr[location]=valueToBeInserted;
                System.out.println("data inserted sucessfully");
            }
            else {
                System.out.println("this cell is already accupied");
            }

        }catch (Exception e){
            System.out.println("invalid index to access array");

        }


    }
    public void searchInArray(int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToSearch) {
                System.out.println("Value is found at the index of " + i);
                return;
            }
        }
        System.out.println(valueToSearch + " is not found");
    }


    public static void main(String[] args) {
        ArraySingleDimSearch array2 =new ArraySingleDimSearch(10);
        array2.insert(0,12);
        array2.insert(1,23);
        array2.insert(0,12);
        array2.insert(11,34);
        array2.searchInArray(12);


    }
}


//output
//data inserted sucessfully
//        data inserted sucessfully
//        this cell is already accupied
//        invalid index to access array
//Value is found at the index of 0