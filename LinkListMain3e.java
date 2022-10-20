package Linkexerise3.partision;

//Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
//
//        Example
//
//        Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [x=5]
//
//        Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

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
     singleLinkList partition(singleLinkList ll, int x) {
         Node currentNode = ll.head;
         ll.tail = ll.head;
         while (currentNode != null) {
             Node next = currentNode.next;
             if (currentNode.value < x) {
                 currentNode.next = ll.head;
                 ll.head = currentNode;
             } else {
                 ll.tail.next = currentNode;
                 ll.tail = currentNode;
             }
             currentNode = next;
         }
         ll.tail.next = null;
         return ll;
     }
}


public class LinkListMain3 {
    public static void main(String[] args) {
        singleLinkList list=new singleLinkList();
        list.CreateSll(3);
        list.insertSll(5);
        list.insertSll(8);
        list.insertSll(5);
        list.insertSll(10);
        list.insertSll(2);
        list.insertSll(1);

        list.travarsal();
        Operation operation=new Operation();
        singleLinkList ss=operation.partition(list,3);
        ss.travarsal();


    }
}

//output
//3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
//
//        1 -> 2 -> 3 -> 5 -> 8 -> 5 -> 10