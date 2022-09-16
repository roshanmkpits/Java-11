public class ChallangeDecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double firstNumber, double secondNumber) {
        if ((int)(firstNumber * 10000) == (int)(secondNumber * 10000)) {
            return true;
        } else {
            return false;
        }
    }
        public static void main(String[] args) {
            System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.17568));
            System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176));
            System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));
            System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123));

    }
}
