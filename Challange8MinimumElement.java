import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Challange8MinimumElement {

    private static Scanner scanner=new Scanner(System.in);

    public void  readInteger(){
        System.out.println("How many numbers would you like to enter?");
        int numbers = scanner.nextInt();
        System.out.println("Please enter your numbers?");
        int[] intArray = readElements(numbers);
        System.out.println(""+ Arrays.toString(intArray));
        int min = findMin(intArray);
        System.out.println("The minimum element in the array is " + min);

    }
    public int[]  readElements(int num){

        int[] array = new int[num];
        for (int i=0; i<num; i++) {
            array[i] = scanner.nextInt();
        }
        return array;

    }
    public int  findMin(int[] array){
        int min = array[0];
        for (int i=0; i<array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;

    }


    public static void main(String[] args) {

        Challange8MinimumElement ob1=new Challange8MinimumElement();
        ob1.readInteger();




    }
}
