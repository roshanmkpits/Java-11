package link3.demo;
//create a linklist with single node,head and tail
//inser node at loc
//traversing linklist
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

        public void traverseSinglyLinkedList() {
            if (head == null) {
                System.out.println("SLL does not exist!");
            } else {
                Node tempNode = head;
                for (int i = 0; i<size; i++) {
                    System.out.print(tempNode.value);
                    if (i != size - 1) {
                        System.out.print(" -> ");
                    }
                    tempNode = tempNode.next;
                }
            }
            System.out.println("\n");
        }
    }

public class LinkListMain2 {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        singlyLinkedList.createSinglyLinkedList(5);
        singlyLinkedList.insertInLinkedList(15,1);
        singlyLinkedList.insertInLinkedList(16,1);
        singlyLinkedList.insertInLinkedList(17,1);
        singlyLinkedList.traverseSinglyLinkedList();
    }
}

//output
//5 -> 17 -> 16 -> 15