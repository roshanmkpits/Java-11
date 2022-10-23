package cirqueue6.dequedelete;

//create a circular Queue
//with given size
//create isEmpty ,isFull method
class CirQueArray{
    int arry[];
    int topOfQueue;
    int begOfQueue;
    int size;
    CirQueArray(int size){
        arry=new int[size];
        this.size=size;
        topOfQueue=-1;
        begOfQueue=-1;
        System.out.println("Circular Queue created sucesslly of size : "+this.size);
    }
    public boolean isEmpty() {
        if (topOfQueue == -1) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isFull() {
        if (topOfQueue+1 == begOfQueue) {
            return true;
        } else if (begOfQueue==0 && topOfQueue+1==size) {
            return true;
        } else {
            return false;
        }
    }

    // enQueue
    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The CQ is full!");
        } else if (isEmpty()) {
            begOfQueue = 0;
            topOfQueue++;
            arry[topOfQueue] = value;
            System.out.println("Successfully inserted "+value+" in the queue");
        } else {
            if (topOfQueue+1 == size) {
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            arry[topOfQueue] = value;
            System.out.println("Successfully inserted "+value+" in the queue");
        }
    }

    // deQueue
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The CQ is empty!");
            return -1;
        } else {
            int result = arry[begOfQueue];
            arry[begOfQueue] = 0;
            if (begOfQueue == topOfQueue) {
                begOfQueue = topOfQueue = -1;
            } else if (begOfQueue+1 == size) {
                begOfQueue = 0;
            } else {
                begOfQueue++;
            }
            return result;
        }
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("The CQ is emtpy");
            return -1;
        } else {
            return arry[begOfQueue];
        }
    }

    // deleteQueue
    public void deleteQueue() {
        arry = null;
        System.out.println("The CQ is successfully deleted!");
    }


}
public class CircularQueMain6 {
    public static void main(String[] args) {
        CirQueArray cirQueArray=new CirQueArray(3);
        cirQueArray.enQueue(2);
        cirQueArray.enQueue(3);
        cirQueArray.enQueue(4);
        System.out.println("peek : "+cirQueArray.peek());
        System.out.println("removed from circular queue : "+cirQueArray.deQueue());
        cirQueArray.deleteQueue();



    }
}
//    Circular Queue created sucesslly of size : 3
//        Successfully inserted 2 in the queue
//        Successfully inserted 3 in the queue
//        Successfully inserted 4 in the queue
//        peek : 2
//        removed from circular queue : 2
//        The CQ is successfully deleted!