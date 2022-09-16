public class ChallangeEqualSumChecker {

    public static boolean hasEqualSum(int firstNum, int secondNum, int thirdNum){

        if(firstNum + secondNum == thirdNum){
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(hasEqualSum(1, 1, 1));
        System.out.println(hasEqualSum(1, 1, 2));
        System.out.println(hasEqualSum(1, -1, 0));
    }
}
