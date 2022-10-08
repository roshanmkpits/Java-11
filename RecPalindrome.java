//Write a recursive function called isPalindrome which returns true if the string passed to it is a palindrome (reads the same forward and backward). Otherwise it returns false.
//
//        Examples
//
//        isPalindrome('awesome') # false
//        isPalindrome('foobar') # false
//        isPalindrome('tacocat') # true


public class RecPalindrome {
    public static void main(String[] args) {
        RecPalindrome recPalindrome=new RecPalindrome();
        boolean rec= recPalindrome.isPalindrome("nayan");
        System.out.println(rec);

    }

    public  boolean isPalindrome(String s)
    {   // if length is 0 or 1 then String is palindrome
        if(s.length() == 0 || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
            return isPalindrome(s.substring(1, s.length()-1));
        return false;
    }
}
//output
// true