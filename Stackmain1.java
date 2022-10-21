package stack1.create;

//create a stack with size
//perform isempty logic
//perform isfull logic
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

    }

public class Stackmain1 {
    public static void main(String[] args) {
        Stack stack=new Stack(4);
        boolean res=stack.isEmpty();
        System.out.println("isEmpty = "+res);
         res=stack.isFull();
        System.out.println("isFull = "+res);
    }
}

//output
//Stack created with size = 4
//isEmpty = true
//        isFull = false