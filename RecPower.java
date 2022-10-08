//Write a function called power which accepts a base and an exponent. The function should return the power of the base to the exponent. This function should mimic the functionality of math.pow() - do not worry about negative bases and exponents.
//
//        Examples
//
//        power(2,0) // 1
//        power(2,2) // 4
//        power(2,4) // 16
//          
//        Line 1, Column 1
//        All changes saved


public class RecPower {
    public static void main(String[] args) {

        RecPower power=new RecPower();
        int rec= power.power(2,4);
        System.out.println(rec);

    }

    public int power(int base,int exponent) {
        //unintensional case
        if (base<0) {
            return -1;
        }
        //base case
        if (exponent==0 ) {
            return 1;
        }
        //recursive case
        return base * power(base,exponent-1);
    }
}

//output
// 16