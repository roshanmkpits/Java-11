package linkexerise4.sumlist;

//ou have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
//
//        list1 = 7 -> 1 -> 6
//        list2 =  5 -> 9 -> 2
//        result = 2 -> 1 -> 9

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
        if (head == null) {
            CreateSll(nodeValue);
            return;
        }
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

 class Operation {
     singleLinkList sumLists(singleLinkList llA, singleLinkList llB) {
         Node n1 = llA.head;
         Node n2 = llB.head;
         int carry = 0;
         singleLinkList resultLL = new singleLinkList();
         while (n1 != null || n2 != null) {
             int result = carry;
             if (n1 != null) {
                 result += n1.value;
                 n1 = n1.next;
             }
             if (n2 != null) {
                 result += n2.value;
                 n2 = n2.next;
             }
             resultLL.insertSll(result%10);
             carry = result / 10;
         }
         return resultLL;
     }

}


public class LinkListMain4 {
    public static void main(String[] args) {
        singleLinkList list=new singleLinkList();
        list.CreateSll(7);
        list.insertSll(1);
        list.insertSll(6);
        singleLinkList list1=new singleLinkList();
        list.CreateSll(5);
        list1.insertSll(9);
        list1.insertSll(2);





        Operation operation=new Operation();
        singleLinkList ss=operation.sumLists(list,list1);
        ss.travarsal();


    }
}

//output
//3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
//
//        1 -> 2 -> 3 -> 5 -> 8 -> 5 -> 10