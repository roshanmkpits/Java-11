//Implement Queue class which implements a queue using two stacks.

class MyStack<T> {

    // inner generic Node class
    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size;

    public void push(T e) {
        Node<T> newElem = new Node(e);

        if(head == null) {
            head = newElem;
        } else {
            newElem.next = head;
            head = newElem;     // new elem on the top of the stack
        }

        size++;
    }

    public T pop() {
        if(head == null)
            return null;

        T elem = head.data;
        head = head.next;   // top of the stack is head.next

        size--;

        return elem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printStack() {
        System.out.print("Stack: ");

        if(size == 0)
            System.out.print("Empty !");
        else
            for(Node<T> temp = head; temp != null; temp = temp.next)
                System.out.printf("%s ", temp.data);

        System.out.printf("\n");
    }
}
 class MyQueue<T> {

    private MyStack<T> inputStack;      // for enqueue
    private MyStack<T> outputStack;     // for dequeue
    private int size;

    public MyQueue() {
        inputStack = new MyStack<>();
        outputStack = new MyStack<>();
    }

    public void enqueue(T e) {
        inputStack.push(e);
        size++;
    }

    public T dequeue() {
        // fill out all the Input if output stack is empty
        if(outputStack.isEmpty())
            while(!inputStack.isEmpty())
                outputStack.push(inputStack.pop());

        T temp = null;
        if(!outputStack.isEmpty()) {
            temp = outputStack.pop();
            size--;
        }

        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
public class QueStack {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        // enqueue integers 1..3
        for(int i = 1; i <= 3; i++)
            queue.enqueue(i);

        // execute 2 dequeue operations
        for(int i = 0; i < 2; i++)
            System.out.println("Dequeued: " + queue.dequeue());

        // enqueue integers 4..5
        for(int i = 4; i <= 5; i++)
            queue.enqueue(i);

        // dequeue the rest
        while(!queue.isEmpty())
            System.out.println("Dequeued: " + queue.dequeue());
    }
    }

//Dequeued: 1
//        Dequeued: 2
//        Dequeued: 3
//        Dequeued: 4
//        Dequeued: 5