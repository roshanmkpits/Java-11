public class ArraySingleDimInsert {
    int arr[]=null;

    public ArraySingleDimInsert(int arraySize) {
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

    public static void main(String[] args) {
        ArraySingleDimInsert insert=new ArraySingleDimInsert(10);
        insert.insert(0,12);
        insert.insert(1,23);
        insert.insert(0,12);
        insert.insert(11,34);
    }
}


//output
//data inserted sucessfully
//        data inserted sucessfully
//        this cell is already accupied
//        invalid index to access array