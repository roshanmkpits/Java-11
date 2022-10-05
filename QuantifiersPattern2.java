package regx4.quntifiers2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//example of quntifier and pattern
//program to find 0ccurence of h1 tag in string builder
//Greedy quantifiers
//        X?	X, once or not at all
//        X*	X, zero or more times
//        X+	X, one or more times
//        X{n}	X, exactly n times
//        X{n,}	X, at least n times
//        X{n,m}	X, at least n but not more than m times
//
//        Reluctant quantifiers
//        X??	X, once or not at all
//        X*?	X, zero or more times
//        X+?	X, one or more times
//        X{n}?	X, exactly n times
//        X{n,}?	X, at least n times
public class QuantifiersPattern2 {

    public static void main(String[] args) {
//        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
//        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));
//        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));
//        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));
//        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YYY"));
//        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());


        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());

        }

    }
}

//output
//false
//        Occurrence 1 : 19 to 23
//        Occurrence 2 : 136 to 140