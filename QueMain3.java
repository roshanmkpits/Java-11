package queue3.enqueDqueue;
//create Queue using array
//of given size
//create isempty,isfull method
//enqueue
//dequeue
class QueueArray {
    int []arry;
    int topOfQueue;
    int begOfQueue;

    QueueArray(int size) {
        arry=new int[size];
        topOfQueue=-1;
        begOfQueue=-1;
        System.out.println("Queue created sucessfully of size : "+size);
    }
    public boolean isFull(){
        if(topOfQueue==arry.length-1){
            return  true;
        }else {
            return false;
        }
    }
    public boolean isEmpty(){
        if(begOfQueue==-1 || begOfQueue==arry.length){
            return true;
        }else{
            return false;
        }
    }

    public void enQueue(int value){
        if(isFull()){
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            begOfQueue=0;
            topOfQueue++;
            arry[topOfQueue]=value;
            System.out.println("value inserted in queue : "+value);
        }else{
            topOfQueue++;
            arry[topOfQueue]=value;
            System.out.println("value inserted in queue : "+value);

        }
    }

    public int deQueue(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return  -1;
        } else {
            int res=arry[begOfQueue];
            begOfQueue++;
            if(begOfQueue>topOfQueue){
                begOfQueue=topOfQueue=-1;
            }
            return res;

        }
    }


}
public class QueMain3 {
    public static void main(String[] args) {
        QueueArray queueArray=new QueueArray(6);
        queueArray.enQueue(2);
        queueArray.enQueue(3);
        queueArray.enQueue(4);
        queueArray.enQueue(4);
        System.out.println("value removed from queue : "+queueArray.deQueue());
        System.out.println("value removed from queue : "+queueArray.deQueue());
        System.out.println("value removed from queue : "+queueArray.deQueue());
        System.out.println("value removed from queue : "+queueArray.deQueue());
        System.out.println("value removed from queue : "+queueArray.deQueue());


    }
}


//    Queue created sucessfully of size : 6
//        value inserted in queue : 2
//        value inserted in queue : 3
//        value inserted in queue : 4
//        value inserted in queue : 4
//        value removed from queue : 2
//        value removed from queue : 3
//        value removed from queue : 4
//        value removed from queue : 4
//        stack is empty
//        value removed from queue : -1