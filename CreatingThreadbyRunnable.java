package thread1.threadbyrunnable;

import static thread1.threadbyrunnable.ThreadColor.ANSI_RED;

//thread color class  is used to display output in color
//creating a thread by implementing runnable interface
//display a message by thread
//sleep for 30 sec

 class ThreadColor {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
}

 class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from MyRunnable's implementation of run()");
    }
}


public class CreatingThreadbyRunnable {
   public static void main(String[] args) {
      MyRunnable anotherThread = new MyRunnable();
      anotherThread.run();


   }
}

//output
//Hello from MyRunnable's implementation of run()