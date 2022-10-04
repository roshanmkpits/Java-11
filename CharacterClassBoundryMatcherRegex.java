package regex2.charclassboundrymatcher;

//character class and boundary matcher exapmle with regex
public class CharacterClassBoundryMatcherRegex {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";


        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        System.out.println(hasWhitespace.replaceAll("\\S", ""));
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));



    }
}
//output
//    I am a string. Yes, I am.
//        You am a string. Yes, You am.
//        abcDeeeF12GhhiiiTHE END
//        XbcDXXXF12GhhXXXXjkl99z
//        I replaced a letter herebcDI replaced a letter hereI replaced a letter hereI replaced a letter hereF12GhhI replaced a letter hereI replaced a letter hereI replaced a letter hereI replaced a letter herejkl99z
//        abcDeeX12GhhiiiXkl99z
//        Harry
//        XXXXeeeXXXXXXXXXXjXXXXX
//        XXXDXXXF12Ghhiiiijkl99z
//        XXXXXXXX12Ghhiiiijkl99z
//        XXXXXXXX12Ghhiiiijkl99z
//        abcDeeeFXXGhhiiiijklXXz
//        abcDeeeFXXGhhiiiijklXXz
//        XXXXXXXX12XXXXXXXXXX99X
//        I have blanks and	a tab, and also a newline
//
//        Ihaveblanksandatab,andalsoanewline
//        I have blanks andXa tab, and also a newline
//
//
//
//        XXXXXXXXXXXXXXXXXXXXXXX
//        X XXXX XXXXXX XXX	X XXX, XXX XXXX X XXXXXXX
//
//        XIX XhaveX XblanksX XandX	XaX XtabX, XandX XalsoX XaX XnewlineX
