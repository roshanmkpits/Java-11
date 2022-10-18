package double5.linklist;

//create a double linklist with single node
//insert operation with doublelink list
//search operation
//reverse operation
//delete operation 

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
    //Traverse DLL
    public void traverseDLL() {
        if (head != null) {
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size-1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        } else {
            System.out.println("The DLL does not exist!");
        }
        System.out.println("\n");
    }

    // Reverse Traverse
    public void reverseTraverseDLL() {
        if (head != null) {
            DoubleNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size-1) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.prev;
            }
        } else {
            System.out.println("The DLL does not exist!");
        }
        System.out.println("\n");
    }

    // Search Node
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.print("The Node is found at location: " +i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("Node not found!");
        return false;
    }

    // Deletion Method
    public void deleteNodeDLL(int location) {
        if (head == null) {
            System.out.println("The DLL does not exist!");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return;
            } else {
                head = head.next;
                head.prev = null;
                size--;
            }
        } else if (location >= size) {
            DoubleNode tempNode = tail.prev;
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return;
            } else {
                tempNode.next = null;
                tail = tempNode;
                size--;
            }
        } else {
            DoubleNode tempNode = head;
            for (int i = 0; i < location-1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    // Delete entire DLL
    public void deleteDLL() {
        DoubleNode tempNode = head;
        for (int i =0; i< size; i++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("The DLL has been deleted!");
    }
}
public class DoubleLinkMain5 {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList=new DoubleLinkList();
        doubleLinkList.createDll(12);
        doubleLinkList.insertDLL(23,1);
        doubleLinkList.insertDLL(13,2);
        doubleLinkList.traverseDLL();
        doubleLinkList.reverseTraverseDLL();
        doubleLinkList.searchNode(13);
//        System.out.println(doubleLinkList.head.value);

    }
}
//output
//12 -> 23 -> 13
//
//        13 <- 23 <- 12
//
//        The Node is found at location: 2