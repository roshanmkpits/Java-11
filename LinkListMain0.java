package linkexerise.create;

class Node{
    int value;
    Node next;

}

class singleLinkList{
    Node head;
    Node tail;
    int size;
    public  void CreateSll(int nodeValue){
        Node newNode=new Node();
        newNode.value=nodeValue;
        newNode.next=null;
        head=newNode;
        tail=newNode;
        size=1;
    }
    public void insertSll(int nodeValue){//assume node inserted at last
        Node newNode=new Node();
        newNode.value=nodeValue;
        newNode.next=null;
        tail.next=newNode;
        tail=newNode;
        size++;
    }
    public void travarsal()
    {
        Node tempNode = head;
        for (int i =0; i<size; i++) {
            System.out.print(tempNode.value);
            if (i != size -1) {
                System.out.print(" -> ");
            }
            tempNode = tempNode.next;
        }
        System.out.println("\n");
    }

}


public class LinkListMain {
    public static void main(String[] args) {
        singleLinkList list=new singleLinkList();
        list.CreateSll(1);
        list.insertSll(12);
        list.insertSll(13);
        list.insertSll(14);
        list.travarsal();
    }
}
