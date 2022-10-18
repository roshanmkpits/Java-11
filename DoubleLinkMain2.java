package Double2.linklist;

//create a double linklist with single node
//insert operation with doublelink list

class DoubleNode{
    int value;
    DoubleNode next;
    DoubleNode prev;

}
class DoubleLinkList{
    DoubleNode head;
    DoubleNode tail;
    int size;
    public DoubleNode createDll(int nodevalue) {
        head=new DoubleNode();
        DoubleNode newnode=new DoubleNode();
        newnode.value=nodevalue;
        newnode.next=null;
        newnode.prev=null;
        head=newnode;
        tail=newnode;
        size=1;
        return head;

    }

    // Insertion Method
    public void insertDLL(int nodeValue, int location) {
        DoubleNode newNode = new DoubleNode();
        newNode.value = nodeValue;
        if (head == null) {
            createDll(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoubleNode tempNode = head;
            int index = 0;
            while (index < location-1) {
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
public class DoubleLinkMain2 {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList=new DoubleLinkList();
        doubleLinkList.createDll(12);
        doubleLinkList.insertDLL(23,1);
        doubleLinkList.insertDLL(13,2);
//        System.out.println(doubleLinkList.head.value);

    }
}
//output
//12 