public class ArraySingleDimTraverse {
    int arr[]=null;

    public ArraySingleDimTraverse(int arraySize) {
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

    public void traverse(){
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        } catch (Exception e) {
            System.out.println("Array no longer exists!");
        }

    }

    public static void main(String[] args) {
        ArraySingleDimTraverse array2 =new ArraySingleDimTraverse(10);
        array2.insert(0,12);
        array2.insert(1,23);
        array2.insert(0,12);
        array2.insert(11,34);
        array2.traverse();

    }
}


//output
//data inserted sucessfully
//        data inserted sucessfully
//        this cell is already accupied
//        invalid index to access array
//12 23 -2147483648 -2147483648 -2147483648 -2147483648 -2147483648 -2147483648 -2147483648 -2147483648