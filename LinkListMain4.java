package link4.demo;
//create a linklist with single node,head and tail
//inser node at loc
//traversing linklist
//search node 
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

        // Search for a node

        boolean searchNode(int nodeValue) {
            if (head != null) {
                Node tempNode = head;
                for (int i=0; i<size; i++) {
                    if (tempNode.value == nodeValue) {
                        System.out.print("Found the node at location: " +i+"\n");
                        return true;
                    }
                    tempNode = tempNode.next;
                }
            }
            System.out.print("Node not found! ");
            return false;
        }
    }

public class LinkListMain4 {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        singlyLinkedList.createSinglyLinkedList(5);
        singlyLinkedList.insertInLinkedList(15,1);
        singlyLinkedList.insertInLinkedList(16,1);
        singlyLinkedList.insertInLinkedList(17,1);
        singlyLinkedList.traverseSinglyLinkedList();
        System.out.println(singlyLinkedList.searchNode(16));
    }
}

//output
//5 -> 17 -> 16 -> 15
//
//        Found the node at location: 2
//        true