package circulardouble4.linklist;

//create a circular double linklist with one node
//create a DoubleNode class
//create Circulardouble class with createCdll method
//perform insert operation
//perform traverse operation
//perform reverse operation

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



}

public class CircularDoubleMain4 {
    public static void main(String[] args) {
        CircularDouble circularDouble=new CircularDouble();
        circularDouble.createCdll(12);
        System.out.println(circularDouble.head.value);
        circularDouble.insertNode(13,1);
        circularDouble.insertNode(18,2);
        circularDouble.insertNode(24,3);
        circularDouble.traverseCDLL();
        circularDouble.reverseTraversalCDLL();

    }
}
//
//12
//        12 -> 13 -> 18 -> 24
//        24 <- 18 <- 13 <- 12