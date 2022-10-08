//Write a function called recursiveRange which accepts a number and adds up all the numbers from 0 to the number passed to the function.
//
//        Examples
//
//        recursiveRange(6)  // 21
//        recursiveRange(10) // 55
public class RecRangeSolution {
    public static void main(String[] args) {

        RecRangeSolution solution=new RecRangeSolution();
        int rec=solution.recursiveRange(6);
        System.out.println(rec);

    }

    public int recursiveRange(int num) {
        if (num<=0) {
            return 0;
        }
        return num + recursiveRange(num - 1);
    }
}
//output
// 21