package linklist1;
//create a linklist with single node,head and tail
 class Node {
     int value;
     Node next;
}
    class SinglyLinkedList {
        public Node head;
        public Node tail;
        public int size;

        public Node createSinglyLinkedList(int nodeValue) {
            head = new Node();
            Node node = new Node();
            node.next = null;
            node.value = nodeValue;
            head = node;
            tail = node;
            size = 1;
            return head;
        }
    }

public class LinkListMain {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        singlyLinkedList.createSinglyLinkedList(5);
        System.out.println(singlyLinkedList.head.value);
    }
}

//output
//5