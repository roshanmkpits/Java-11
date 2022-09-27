import java.util.*;

//create 2 sets of type integer
//one set add squre of 1 to 100
//another set add cube of 1 to 100
public class Challange12SymmeticAsymmetricSet {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i=1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + "  elements.");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements.");
        for(int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }



    }
}
//output
//There are 100 squares and 100 cubes.
//        Union contains 196  elements.
//        Intersection contains 4 elements.
//        4096 is the square of 64.0 and the cube of 16.0
//        1 is the square of 1.0 and the cube of 1.0
//        64 is the square of 8.0 and the cube of 4.0
//        729 is the square of 27.0 and the cube of 9.0
