package tri2.insert;

import java.util.HashMap;
import java.util.Map;
// creation of trie for storing and searching string
//insert operation in trie
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

    void insert(String word){
        TrieNode current=root;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            TrieNode node=current.children.get(ch);
            if(node==null){
                node=new TrieNode();
                current.children.put(ch,node);
            }
            current=node;
        }

        current.endOfString=true;
        System.out.println("sucessfully inserted  word "+word+" in trie");
    }

}
public class TrieMain2 {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("app");
        trie.insert("appl");


    }
}
//
//    Trie created sucessfully
//        sucessfully inserted  word app in trie
//        sucessfully inserted  word appl in triesfully