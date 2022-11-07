package search2.binary;
//binary search
class Binary{
    int searchBinary(int a[],int value){
        int start=0;
        int end=a.length-1;
        int middle=(start+end)/2;
        while (a[middle]!=value && start<=end){
            if(value < a[middle]){
                end=middle-1;
            }else {
                start=middle+1;
            }
            middle=(start+end)/2;
            System.out.println(start +" "+middle+" "+end);
        }
        if(a[middle]==value){
            System.out.println("value found at "+middle);
            return middle;
        }else {
            System.out.println("value not found ");
            return -1;
        }

    }
}
public class BinarySearMain {

    public static void main(String[] args) {
        Binary binary = new Binary();
        int a[] = {1, 3, 4, 6, 8, 9};
        binary.searchBinary(a, 2);
        binary.searchBinary(a, 3);
    }
}

//
//        0 0 1
//        1 1 1
//        1 0 0
//        value not found
//        0 0 1
//        1 1 1
//        value found at 1