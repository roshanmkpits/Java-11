package criculardouble1.linklist;

//create a circular double linklist with one node
//create a DoubleNode class
//create Circulardouble class with createCdll method

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


}

public class CircularDoubleMain {
    public static void main(String[] args) {
        CircularDouble circularDouble=new CircularDouble();
        circularDouble.createCdll(12);
        System.out.println(circularDouble.head.value);

    }
}
//output
// 12