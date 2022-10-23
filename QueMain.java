package que1.create;

//create Queue using array
//of given size
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


}
public class QueMain {
    public static void main(String[] args) {
        QueueArray queueArray=new QueueArray(6);

    }
}


//output
//Queue created sucessfully of size : 6