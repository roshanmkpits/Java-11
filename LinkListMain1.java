package linkExerise1.dup;

import java.util.HashSet;

//create a singlelinklist and delete the duplicates

class Node{
    int value;
    Node next;

}

class singleLinkList{
    Node head;
    Node tail;
    int size;
    public  void CreateSll(int nodeValue){
        Node newNode=new Node();
        newNode.value=nodeValue;
        newNode.next=null;
        head=newNode;
        tail=newNode;
        size=1;
    }
    public void insertSll(int nodeValue){//assume node inserted at last
        Node newNode=new Node();
        newNode.value=nodeValue;
        newNode.next=null;
        tail.next=newNode;
        tail=newNode;
        size++;
    }
    public void travarsal()
    {
        Node tempNode = head;
        for (int i =0; i<size; i++) {
            System.out.print(tempNode.value);
            if (i != size -1) {
                System.out.print(" -> ");
            }
            tempNode = tempNode.next;
        }
        System.out.println("\n");
    }

}

 class Operation {
    void deleteDups(singleLinkList ll) {
        HashSet<Integer> hs = new HashSet();
        Node current = ll.head;
        Node prev = null;
        while (current != null) {
            int curval = current.value;
            if (hs.contains(curval)) {
                prev.next = current.next;
                ll.size--;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }
}


public class LinkListMain1 {
    public static void main(String[] args) {
        singleLinkList list=new singleLinkList();
        list.CreateSll(1);
        list.insertSll(12);
        list.insertSll(13);
        list.insertSll(13);
        list.travarsal();
        Operation operation=new Operation();
        operation.deleteDups(list);
        list.travarsal();
    }
}

//output
// 1 -> 12 -> 13 -> 13
//
//1 -> 12 -> 13