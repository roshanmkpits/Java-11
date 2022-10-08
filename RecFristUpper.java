
//First Uppercase
//        Given a string find its first uppercase letter
//
//        Example
//
//        Input : appmillerS
//        Output : S


public class RecFristUpper {
    public static void main(String[] args) {
        RecFristUpper upper=new RecFristUpper();
        char rec= upper.first("appmillerS");
        System.out.println(rec);

    }

    public  char first(String str) {
        if(str.isEmpty()) {
            return ' ';
        }
        if (Character.isUpperCase(str.charAt(0))) {
            return str.charAt(0);
        }else {
            return first(str.substring(1, str.length()));
        }
    }
}
//output
// S