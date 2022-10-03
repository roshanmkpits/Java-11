package thread.multple;

//thread color class  is used to display output in color
//creating a thread by extending thread class
//creating two class thread object and passing Countdoun class object to thread
// both thread print 1 to 10 values 

 class ThreadColor {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
}
class Countdown {

//    private int i;

    public void doCountdown() {
        String color;

        switch(Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        for(int i=10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}


public class CreatingMultipleThread {
   public static void main(String[] args) {
       Countdown countdown = new Countdown();

       CountdownThread t1 = new CountdownThread(countdown);
       t1.setName("Thread 1");
       CountdownThread t2 = new CountdownThread(countdown);
       t2.setName("Thread 2");

       t1.start();
       t2.start();
   }
}

//output
//Thread 2: i =10
//        Thread 2: i =9
//        Thread 2: i =8
//        Thread 2: i =7
//        Thread 2: i =6
//        Thread 2: i =5
//        Thread 2: i =4
//        Thread 2: i =3
//        Thread 2: i =2
//        Thread 2: i =1
//        Thread 1: i =10
//        Thread 1: i =9
//        Thread 1: i =8
//        Thread 1: i =7
//        Thread 1: i =6
//        Thread 1: i =5
//        Thread 1: i =4
//        Thread 1: i =3
//        Thread 1: i =2
//        Thread 1: i =1