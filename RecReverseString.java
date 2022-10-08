//
//Write a recursive function called reverse which accepts a string and returns a new string in reverse.
//
//        Examples
//
//        reverse('java') # 'avaj'
//        reverse('appmillers') # 'srellimppa'


public class RecReverseString {
    public static void main(String[] args) {

        RecReverseString string1=new RecReverseString();
        String rec= string1.reverseStr("java");
        System.out.println(rec);
    }

    public String reverseStr(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseStr(str.substring(1)) + str.charAt(0);
    }
}
//output
// avaj