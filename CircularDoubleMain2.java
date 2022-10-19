package circulardouble2.linklist;

//create a circular double linklist with one node
//create a DoubleNode class
//create Circulardouble class with createCdll method
//perform insert operation

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


}

public class CircularDoubleMain2 {
    public static void main(String[] args) {
        CircularDouble circularDouble=new CircularDouble();
        circularDouble.createCdll(12);
        System.out.println(circularDouble.head.value);
        circularDouble.insertNode(13,1);
        circularDouble.insertNode(18,2);
        circularDouble.insertNode(24,3);

    }
}
