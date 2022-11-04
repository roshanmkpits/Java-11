package trie4.delete;

import java.util.HashMap;
import java.util.Map;
// creation of trie for storing and searching string
//search operatio on trie
//delete in trie
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

    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;

        if (currentNode.children.size() > 1) {
            delete(currentNode, word, index+1);
            return false;
        }
        if (index == word.length() -1) {
            if (currentNode.children.size()>=1) {
                currentNode.endOfString = false;
                return false;
            } else {
                parentNode.children.remove(ch);
                return true;
            }
        }
        if (currentNode.endOfString == true) {
            delete(currentNode, word, index+1);
            return false;
        }
        canThisNodeBeDeleted = delete(currentNode, word, index+1);
        if (canThisNodeBeDeleted == true) {
            parentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }

    public void delete(String word) {
        if (search(word) == true) {
            delete(root, word, 0);
        }
    }


}
public class TrieMain4 {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("app");
        trie.insert("appl");
        trie.search("app");
        trie.delete("app");
        trie.search("app");


    }
}
////
//word app exixt in trie
//        word app exixt in trie
//        word app not exixt in trie but prefix of another word