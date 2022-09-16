public class ChallangeTeenNumberChecker {


    public static boolean hasTeen(int num1, int num2, int num3) {
        if ((num1 >= 13 && num1 <= 19) || (num2 >= 13 && num2 <= 19) || (num3 >= 13 && num3 <= 19)) {
            return true;
        }
        return false;
    }

    public static boolean isTeen(int num4) {
        if (num4 >= 13 && num4 <= 19) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println( hasTeen(9, 99, 19));  //return true
        System.out.println(hasTeen(23, 15, 42)); //return true
        System.out.println(hasTeen(22, 23, 34)); //return false
    }
}
