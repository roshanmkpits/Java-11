package double1.linklist;

//create a double linklist with single node
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

}
public class DoubleLinkMain {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList=new DoubleLinkList();
        doubleLinkList.createDll(12);
        System.out.println(doubleLinkList.head.value);

    }
}
//output
//12