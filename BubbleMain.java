package sort1.selection;


import java.util.Arrays;
//selection sort using java
//ascending order

class Bubble {
    int[] bubbleSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int temp;
                if (a[i] < a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }

            }
        }
        return a;
    }
}
 class BubbleMain {
    public static void main(String[] args) {
        Bubble bubble=new Bubble();
        int a[]={10,2,45,1,6};
        System.out.println(Arrays.toString(bubble.bubbleSort(a)));
    }
}


//output
//[1, 2, 6, 10, 45]