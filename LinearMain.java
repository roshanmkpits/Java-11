package search.linear;
//linear search

class Linear{
    int lineSearch(int a[],int value){
        for (int i = 0; i < a.length; i++) {
            if(a[i]==value){
                System.out.println(value+" element fount at index "+i+ "");
                return i;
            }
        }
        System.out.println(value+"  element not fount ");
        return -1;
    }
}
public class LinearMain {
    public static void main(String[] args) {
        Linear linear=new Linear();
        int a[]={10,2,45,1,6};
        linear.lineSearch(a,1);
        linear.lineSearch(a,12);

    }
}

//output
//1 element fount at index 3
//12  element not fount
