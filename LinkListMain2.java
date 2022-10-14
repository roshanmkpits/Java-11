package link2.demo;
//create a linklist with single node,head and tail
//inser node at loc
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
        // Insert Method SinglyLinkedList
        public void insertInLinkedList(int nodeValue, int location) {
            Node node = new Node();
            node.value = nodeValue;
            if (head == null) {
                createSinglyLinkedList(nodeValue);
                return;
            } else if (location == 0) {
                node.next = head;
                head = node;
            } else if (location >= size) {
                node.next = null;
                tail.next = node;
                tail = node;
            } else {
                Node tempNode = head;
                int index = 0;
                while (index < location - 1) {
                    tempNode = tempNode.next;
                    index++;
                }
                Node nextNode = tempNode.next;
                tempNode.next = node;
                node.next = nextNode;
            }
            size++;
        }
    }

public class LinkListMain2 {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        singlyLinkedList.createSinglyLinkedList(5);
        singlyLinkedList.insertInLinkedList(15,1);
        System.out.println(singlyLinkedList.head.value);
    }
}

//output
//5