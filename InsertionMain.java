package sort3.insertion;


import java.util.Arrays;
//insertion sort
class Insertion{
    int [] inserSort(int array[]){
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key > array[j]) {
                array[j + 1] = array[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }
        return array;
    }


}
public class InsertionMain {
    public static void main(String[] args) {
        Insertion insertion=new Insertion();
        int a[]={10,2,45,1,6};
        System.out.println(Arrays.toString(insertion.inserSort(a)));

    }
}


//[1, 2, 6, 10, 45]