//displaying message with anonymous thread class
//equivalent code using lamda expression
public class LambdaWithThread1 {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("calling thread using anonymous");
            }
        }).start();

        new Thread(() -> System.out.println("calling using lamda with thread")).start();
    }
}

//output
//calling thread using anonymous
//    calling using lamda with thread