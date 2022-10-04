//example of regx
// . wild character
// ^ boundary matcher
// [ ] all accourence
// [] []  followed by second bracket
// $ end matcher

public class RegExExample {
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z"));

        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));
    }
}

//output
//I am a string. Yes, I am.
//        You am a string. Yes, You am.
//        YYYYYYYYYYYYYYYYYYYYYYY
//        YYYF12Ghhiiiijkl99z
//        YYYF12GhhabcDeeeiiiijkl99z
//        false
//        false
//        true
//        abcDeeeF12GhhiiiTHE END
//        XbcDXXXF12GhhXXXXjkl99z
//        I replaced a letter herebcDI replaced a letter hereI replaced a letter hereI replaced a letter hereF12GhhI replaced a letter hereI replaced a letter hereI replaced a letter hereI replaced a letter herejkl99z
//        abcDeeX12GhhiiiXkl99z
