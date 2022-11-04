package tri3.search;

import java.util.HashMap;
import java.util.Map;
// creation of trie for storing and searching string
//search operatio on trie
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

    public boolean search(String word){
        TrieNode current=root;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            TrieNode node=current.children.get(ch);
            if(node==null){
                System.out.println("word "+word+" not exixt in trie");
                return false;
            }
            current=node;
        }
        if(current.endOfString==true){
            System.out.println("word "+word+" exixt in trie");
            return true;
        }else{
            System.out.println("word "+word+" not exixt in trie but prefix of another word ");
        }
        return current.endOfString;
    }

}
public class TrieMain3 {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("app");
        trie.insert("appl");
        trie.search("app");
        trie.search("eap");
        trie.search("ap");


    }
}
//
//    Trie created sucessfully
//        sucessfully inserted  word app in trie
//        sucessfully inserted  word appl in trie
//        word app exixt in trie
//        word eap not exixt in trie
//        word ap not exixt in trie but prefix of another word