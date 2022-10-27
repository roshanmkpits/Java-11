//How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in O(1).
class Node{
    int value;
    Node next;
    Node(int value,Node next){
        this.value=value;
        this.next=next;
    }
}

 class StackMin {
    Node top;
    Node min;

    public StackMin() {
        top = null;
        min = null;
    }

    public int min() {
        return min.value;
    }

    public void push(int value) {
        if (min == null) {
            min = new Node(value, min);
        } else if (min.value < value) {
            min = new Node(min.value, min);
        } else {
            min = new Node(value, min);
        }
        top = new Node(value, top);
    }

    public int pop() {
        min = min.next;
        int result = top.value;
        top = top.next;
        return result;
    }
}


public class MInStackMain {
    public static void main(String[] args) {
        StackMin min=new StackMin();
        min.push(2);
        min.push(4);
        min.push(5);
        min.push(8);
        System.out.println("min value in stack "+min.min());

    }
}

//    min value in stack 2