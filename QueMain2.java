package queue2.isemptIsFull;
//create Queue using array
//of given size
//create isempty,isfull method
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


}
public class QueMain2 {
    public static void main(String[] args) {
        QueueArray queueArray=new QueueArray(6);
        System.out.println("isEmpty : "+queueArray.isEmpty());
        System.out.println("isFull : "+queueArray.isFull());

    }
}

//    Queue created sucessfully of size : 6
//        isEmpty : true
//        isFull : false