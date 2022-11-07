package sort2.bubblesort;


import java.util.Arrays;
//selection sort using java
//ascending order

class SelectionSort {
    int[] selectionSort(int a[]) {
        for (int i = 0; i <= a.length-1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                int temp;
                if (a[j] < a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }

            }
        }
        return a;
    }
}
 class SelectionMain {
    public static void main(String[] args) {
        SelectionSort bubble=new SelectionSort();
        int a[]={10,2,45,1,6};
        System.out.println(Arrays.toString(bubble.selectionSort(a)));
    }
}


//output
//[1, 2, 6, 10, 45]