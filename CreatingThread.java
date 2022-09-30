

//thread color class  is used to display output in color
//creating a thread by extending thread class
//display a message by thread
//sleep for 30 sec
//and display wake up message
 class ThreadColor {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
}

  class AnotherThread extends Thread {

    @Override
    public void run() {
       System.out.println(ThreadColor.ANSI_BLUE + "Hello from " + currentThread().getName());

       try {
          Thread.sleep(3000);
       } catch(InterruptedException e) {
          System.out.println(ThreadColor.ANSI_BLUE +  "Another thread woke me up");
       }

       System.out.println(ThreadColor.ANSI_BLUE + "Three seconds have passed and I'm awake");
    }
 }

public class CreatingThread {
   public static void main(String[] args) {
      Thread anotherThread = new AnotherThread();
      anotherThread.setName("== Another Thread ==");
      anotherThread.start();
   }
}

//output
//Hello from == Another Thread ==
//         Three seconds have passed and I'm awake