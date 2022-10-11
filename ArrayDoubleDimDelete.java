//create a two dim array
//initialize in constructoe
//perform insert operation
//delete in 2d array

public class ArrayDoubleDimDelete {
    int arr[][]=null;

    public ArrayDoubleDimDelete(int numberOfRow, int numberOfColoum) {
        arr=new int[numberOfRow][numberOfColoum];
        for (int row=0;row<arr.length;row++){
            for(int col=0;col< arr[0].length;col++)
            arr[row][col]=Integer.MIN_VALUE;
        }
    }

    public void insert(int row,int col,int value){
        try {
            if(arr[row][col]==Integer.MIN_VALUE){
                arr[row][col]=value;
                System.out.println("data inserted sucessfully");
            }
            else {
                System.out.println("this cell is already accupied");
            }

        }catch (Exception e){
            System.out.println("invalid index to access array");

        }


    }

    public void delete(int row, int col) {
        try {
            System.out.println("Successfully deleted: " + arr[row][col]);
            arr[row][col] = Integer.MIN_VALUE;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This index is not valid for array");
        }
    }

    public static void main(String[] args) {
        ArrayDoubleDimDelete insert=new ArrayDoubleDimDelete(5,5);
        insert.insert(0,0,12);
        insert.insert(0,1,112);
        insert.insert(2,2,12);
        insert.insert(0,0,12);
        insert.delete(0,0);
    }
}


//output
//data inserted sucessfully
//        data inserted sucessfully
//        data inserted sucessfully
//        this cell is already accupied
//        Successfully deleted: 12