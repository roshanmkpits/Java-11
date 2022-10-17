package circ.demo1;

//creating a circular single linklist with one node
class Node
{
    int value;
    Node next;
}
class CircularSinglyLinkedList
{
    Node head;
    Node tail;
    int size;
   public  Node createCSLL(int nodeValue){
       head=new Node();
       Node node=new Node();
       node.value=nodeValue;
       node.next=node;
       head=node;
       tail=node;
       size=1;
       return node;


    }
}
public class CirCularSingleNodeLinkList {
    public static void main(String[] args) {
        CircularSinglyLinkedList singlyLinkedList=new CircularSinglyLinkedList();
        singlyLinkedList.createCSLL(12);
        System.out.println(singlyLinkedList.head.value);
        System.out.println(singlyLinkedList.tail.value);

    }
}

//output
//12
//12
////