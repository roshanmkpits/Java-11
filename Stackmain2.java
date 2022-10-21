package stack2.pushpop;

//create a stack with size
//perform isempty logic
//perform isfull logic
//implemnting push,pop,peek delete
class Stack{
    int []arry;
    int topOfStack;
    Stack(int size) {
        arry=new int[size];
        topOfStack=-1;
        System.out.println("Stack created with size = "+size);

    }
    public boolean isEmpty() {
        if (topOfStack == -1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isFull(){

            if(topOfStack==arry.length-1){
                return true;
            }else{
                return  false;
            }
        }
        //push method
    public void push(int value){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }else{
            arry[topOfStack+1]=value;
            topOfStack++;
            System.out.println("The value is successfully inserted");
        }
    }

    //pop method

    public int pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }else{
            int topstack=arry[topOfStack];
            topOfStack--;
            return topstack;

        }
    }
    //peep methos
    public int peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }else{
            return arry[topOfStack];
        }
    }

    //delete
    public  void delete(){
        arry=null;
        System.out.println("stack deleted sucessfully");
    }

    }

public class Stackmain2 {
    public static void main(String[] args) {
        Stack stack=new Stack(4);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());



    }
}

//output
//The value is successfully inserted
//        The value is successfully inserted
//        The value is successfully inserted
//        The value is successfully inserted
//        stack is full
//        15
//        stack is empty
//        stack is empty
//        -1