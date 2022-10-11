//create a two dim array
//initialize in constructoe
//perform insert operation
//traversing 2d array

public class ArrayDoubleDimTraverse {
    int arr[][]=null;

    public ArrayDoubleDimTraverse(int numberOfRow, int numberOfColoum) {
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

    public void traverse() {
        for (int row=0; row < arr.length; row++) {
            for (int col=0; col < arr[0].length; col++) {
                System.out.print(arr[row][col] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayDoubleDimTraverse insert=new ArrayDoubleDimTraverse(5,5);
        insert.insert(0,0,12);
        insert.insert(0,1,112);
        insert.insert(2,2,12);
        insert.insert(0,0,12);
        insert.traverse();
    }
}


//output
//        data inserted sucessfully
//        data inserted sucessfully
//        this cell is already accupied
//        12  112  -2147483648  -2147483648  -2147483648
//        -2147483648  -2147483648  -2147483648  -2147483648  -2147483648
//        -2147483648  -2147483648  12  -2147483648  -2147483648
//        -2147483648  -2147483648  -2147483648  -2147483648  -2147483648
//        -2147483648  -2147483648  -2147483648  -2147483648  -2147483648