package linkexerise2.ntolast;

import java.util.HashSet;

//create a singlelinklist and find N to last

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
//    void deleteDups(singleLinkList ll) {
//        HashSet<Integer> hs = new HashSet();
//        Node current = ll.head;
//        Node prev = null;
//        while (current != null) {
//            int curval = current.value;
//            if (hs.contains(curval)) {
//                prev.next = current.next;
//                ll.size--;
//            } else {
//                hs.add(curval);
//                prev = current;
//            }
//            current = current.next;
//        }
//    }

     Node nthToLast(singleLinkList ll, int n) {
         Node p1 = ll.head;
         Node p2 = ll.head;
         for (int i =0 ; i<n; i++) {
             if (p2 == null) return null;
             p2 = p2.next;
         }
         while (p2 != null) {
             p1 = p1.next;
             p2 = p2.next;
         }
         return p1;
     }
}


public class LinkListMain2 {
    public static void main(String[] args) {
        singleLinkList list=new singleLinkList();
        list.CreateSll(1);
        list.insertSll(12);
        list.insertSll(13);
        list.insertSll(13);
        list.travarsal();
        Operation operation=new Operation();
        Node res=operation.nthToLast(list,2);
        System.out.println(res.value);
//        operation.deleteDups(list);
//        list.travarsal();
    }
}

//output
//1 -> 12 -> 13 -> 13
//
//        13