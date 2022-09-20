import java.util.Arrays;
import java.util.Scanner;

public class challange8ReverseArray {

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = new int[array1.length];
        int j = 0;
        for (int i=0; i<array1.length; i++) {
            array2[0 + j] = array1[array1.length-1-i];
            j++;
        }
        System.out.println("Array in reversed is " + Arrays.toString(array2));
    }
}
