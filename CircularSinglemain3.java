package circularsingle.demo3;
//creating a circular single linklist with one node
//perform insert operation in circular singly list
//check linklist list exists or not
//node is present or not
//perform traverse operation


//
class Node
{
    int value;
    Node next;
}
class  CircularSinglyLinkedList
{
    Node head;
    Node tail;
    int size;
    public Node createCSLL(int nodeValue) {
        head=new Node();
        Node node=new Node();
        node.value=nodeValue;
        node.next=node;
        head=node;
        tail=node;
        size=1;
        return node;
    }
    //  Insertion Method
    public void insertCSLL(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createCSLL(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = head;
        } else if (location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location-1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    // Traversal Method
    public void traverseCSLL() {
        if (head != null) {
            Node tempNode = head;
            for (int i=0; i<size; i++) {
                System.out.print(tempNode.value);
                if (i != size-1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        } else {
            System.out.println("\nLinklist does not exist!");
        }
    }
}
public class CircularSinglemain {
    public static void main(String[] args) {
        CircularSinglyLinkedList singlyLinkedList=new CircularSinglyLinkedList();
        singlyLinkedList.createCSLL(12);
        singlyLinkedList.insertCSLL(13,1);
        singlyLinkedList.insertCSLL(14,2);
        singlyLinkedList.traverseCSLL();

    }
}

//output
//12 -> 13 -> 14