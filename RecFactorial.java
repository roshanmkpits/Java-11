
//input number and find factorial using recursion
public class RecFactorial {


    public static void main(String[] args) {

        RecFactorial recursion = new RecFactorial();
        var rec = recursion.factorial(4);
        System.out.println(rec);

    }

    public int factorial(int n) {
        //unintensional case
        if (n<1) {
            return -1;
        }
        //base case
        if (n==0 || n==1) {
            return 1;
        }
        //recursive case1
        return n * factorial(n-1);
    }
}

//output
//24