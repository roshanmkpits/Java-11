package circulardouble5.linllist;

//create a circular double linklist with one node
//create a DoubleNode class
//create Circulardouble class with createCdll method
//perform insert operation
//perform traverse operation
//perform reverse operation
//peform search and delete operation

class DoubleNode {
    int value;
    DoubleNode next;
    DoubleNode prev;

}

class CircularDouble {
    DoubleNode head;
    DoubleNode tail;
    int size;

    public DoubleNode createCdll(int nodeValue)
    {
        head=new DoubleNode();
        DoubleNode newNode=new DoubleNode();
        newNode.value=nodeValue;
        head=newNode;
        tail=newNode;
        newNode.prev=newNode;
        newNode.next=newNode;
        size=1;
        return head;
    }

    // Insertion Method
    void insertNode(int nodeValue, int location) {
        DoubleNode newNode = new DoubleNode();
        newNode.value = nodeValue;
        if (head == null) {
            createCdll(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        } else if (location >= size) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoubleNode tempNode = head;
            int index = 0;
            while (index < location -1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    // Traverse CDLL
    void traverseCDLL() {
        if (head != null) {
            DoubleNode tempNode = head;
            for (int i=0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        } else {
            System.out.println("The CDLL does not exist.");
        }
        System.out.println();
    }

    // Reverse Traversal
    void reverseTraversalCDLL() {
        if (head != null) {
            DoubleNode tempNode = tail;
            for (int i=0; i<size; i++) {
                System.out.print(tempNode.value);
                if (i != size-1) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.prev;
            }

        } else {
            System.out.println("The CDLL does not exist!");
        }
    }
    // Search for a Node
    boolean searchNode(int nodeValue) {
        if (head != null) {
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("The node is found at location: "+i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found! ");
        return false;
    }

    // Deletion Method
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The CDLL does not exist!");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size--;
                return;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
            }
        } else if (location >= size) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size--;
                return;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                size--;
            }
        } else {
            DoubleNode tempNode = head;
            for (int i = 0; i < location -1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    // Delete Entire CDLL
    public void deleteCDLL() {
        DoubleNode tempNode = head;
        for (int i=0; i<size; i++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("The CDLL has been deleted!");
    }





}

public class CircularDoubleMain5 {
    public static void main(String[] args) {
        CircularDouble circularDouble=new CircularDouble();
        circularDouble.createCdll(12);
        System.out.println(circularDouble.head.value);
        circularDouble.insertNode(13,1);
        circularDouble.insertNode(18,2);
        circularDouble.insertNode(24,3);
        circularDouble.traverseCDLL();
        circularDouble.reverseTraversalCDLL();
        System.out.println();
        circularDouble.searchNode(18);
        System.out.println();
        circularDouble.deleteNode(12);
        System.out.println("after deleting node ");
        circularDouble.traverseCDLL();

    }
}
//
//12
//        12 -> 13 -> 18 -> 24
//        24 <- 18 <- 13 <- 12
//        The node is found at location: 2
//
//        after deleting node
//        12 -> 13 -> 183 <- 12