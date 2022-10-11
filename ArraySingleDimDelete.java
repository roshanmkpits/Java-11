public class ArraySingleDimDelete {
    int arr[]=null;

    public ArraySingleDimDelete(int arraySize) {
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
    public void deleteValue(int valueDeleteAtIndex) {
        try {
            arr[valueDeleteAtIndex] = Integer.MIN_VALUE;
            System.out.println("the value has been deleted successfully");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("the value that is provided is not in the range of array");

        }
    }



    public static void main(String[] args) {
        ArraySingleDimDelete array2 =new ArraySingleDimDelete(10);
        array2.insert(0,12);
        array2.insert(1,23);
        array2.insert(0,12);
        array2.insert(11,34);
        array2.deleteValue(0);



    }
}


//output
//data inserted sucessfully
//        data inserted sucessfully
//        this cell is already accupied
//        invalid index to access array
//the value has been deleted successfully