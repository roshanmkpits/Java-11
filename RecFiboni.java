public class RecFiboni {
    public static void main(String[] args) {
        RecFiboni fiboni=new RecFiboni();
        int rec = fiboni.fibonacci(-1);
        System.out.println(rec);
    }

    public int fibonacci(int n) {
        //unintensional case
        if (n<0) {
            return -1;
        }
        //base case
        if (n==0 || n==1) {
            return n;
        }
        //recursive case
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

//output
//-1