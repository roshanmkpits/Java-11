package sort4.quick;

//quick sort
class QuickSort {

     int partition(int[] array, int start, int end) {
        int pivot = end;
        int i = start - 1;
        for (int j= start; j<=end; j++) {
            if (array[j] <= array[pivot]) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        return i;
    }

    void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot -1);
            quickSort(array, pivot + 1, end);
        }
    }

void printArray(int []array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"  ");
        }
    }

}

public class Quickmain {
    public static void main(String[] args) {
        int a[]={10,2,45,1,6};
        QuickSort quickSort=new QuickSort();
        quickSort.quickSort(a,0, a.length-1);
        quickSort.printArray(a);


    }
}


//1  2  6  10  45