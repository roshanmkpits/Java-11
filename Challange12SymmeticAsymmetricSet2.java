

//addion prev example
//create set of string
// create a string sentence
// extract word from sentence
//add to set
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Challange12SymmeticAsymmetricSet2 {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i=1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }



        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for(String s : words) {
            System.out.println(s);
        }

//        Set<String> nature = new HashSet<>();
//        Set<String> divine = new HashSet<>();
//        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
//        nature.addAll(Arrays.asList(natureWords));
//
//        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
//        divine.addAll(Arrays.asList(divineWords));

    }
}

//output
//the
//  in
//    year
//   one
//    of
//  day
//fox