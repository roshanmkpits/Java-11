package cirqueue5.insert;

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


}
public class CircularQueMain5 {
    public static void main(String[] args) {
        CirQueArray cirQueArray=new CirQueArray(3);
        System.out.println("isEmpt : "+cirQueArray.isEmpty() );
        System.out.println("isFull : "+cirQueArray.isFull() );


    }
}

//
//    Circular Queue created sucesslly of size : 3
//        isEmpt : true
//        isFull : false