package tri1.create;

import java.util.HashMap;
import java.util.Map;
// creation of trie for storing and searching string
class TrieNode{
    Map<Character,TrieNode> children;
    boolean endOfString;
    TrieNode(){
        children=new HashMap<>();
        endOfString=false;
    }

}

class Trie{
    TrieNode root;
    Trie(){
        root=new TrieNode();
        System.out.println(" Trie created sucessfully ");
    }

}
public class TrieMain {
    public static void main(String[] args) {
        Trie trie=new Trie();


    }
}

// Trie created sucessfully