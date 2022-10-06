package debug2.linebreak;
//create a StringUtilities
// ceate addChar method accept 2 parameter
//append character to string buffer
//in main add character in string buffer till  length < 10

class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder, char c) {
        this.sBuilder.append(c);
        charsAdded++;
    }
}



public class LIneBreakDebug2 {

    public static void main(String[] args) {
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10) {
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);
    }
}
//output
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//        at java.base/java.util.Arrays.copyOf(Arrays.java:3745)
//        at java.base/java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:172)
//        at java.base/java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:748)
//        at java.base/java.lang.StringBuilder.append(StringBuilder.java:241)
//        at StringUtilities.addChar(LIneBreakDebug.java:6)
//        at LIneBreakDebug.main(LIneBreakDebug.java:19)