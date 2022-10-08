//
//capitalizeWord
//        Implement a function that capitalizes each word in String.
//
//        Example
//
//        input: i love java
//        output : I Love Java
public class RecCapitalWord {
    public static void main(String[] args) {
        RecCapitalWord capitalWord=new RecCapitalWord();
        String rec= capitalWord.capitalizeWord("i love java");
        System.out.println(rec);
    }

    public String capitalizeWord(String str) {

        if(str.isEmpty()) {
            return str;
        }
        char chr = str.charAt(str.length()-1);
        if(str.length()==1) {
            return Character.toString(Character.toUpperCase(chr));
        }
        if((str.substring(str.length()-2, str.length()-1).equals(" "))) {
            chr = Character.toUpperCase(chr);
        }
        return capitalizeWord(str.substring(0,str.length()-1))+ Character.toString(chr);
    }

}

//output
//I Love Java