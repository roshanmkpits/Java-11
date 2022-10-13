package array13;

//Given 2D array calculate the sum of diagonal elements.
//
//        Example
//
//        myArray2D= {{1,2,3},{4,5,6},{7,8,9}};
//
//        sumDiagonal(myArray2D) # 15
public class Array2dDiagonal {
    public static void main(String[] args) {
        int [][]myArray2D= {
                           {1,2,3},
                           {4,5,6},
                           {7,8,9}
                           };
        Array2dDiagonal dDiagonal=new Array2dDiagonal();
        int res=dDiagonal.diagonalsum(myArray2D);
        System.out.println("Sum of Diagonal = "+res);

    }

    public  int diagonalsum(int [][]arry) {
        int sum=0;
        for (int i = 0; i <arry.length ; i++) {
            for (int j = 0; j < arry[0].length; j++) {
                if(i==j){
                    sum+=arry[i][j];
                }
            }

        }
        return sum;
    }
}

//output
//Sum of Duagonal = 15