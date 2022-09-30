package thread3.intrptjoin;



//thread color class  is used to display output in color
//intruppt and joining of thread example





import static thread3.intrptjoin.ThreadColor.*;

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
      System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

      try {
         Thread.sleep(3000);
      } catch(InterruptedException e) {
         System.out.println(ANSI_BLUE +  "Another thread woke me up");
         return;
      }

      System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
   }
}
 class MyRunnable implements Runnable {

   @Override
   public void run() {
      System.out.println(ANSI_RED + "Hello from MyRunnable's implementation of run()");
   }
}


public class ThreadIntruptJoin {
   public static void main(String[] args) {

      System.out.println(ANSI_PURPLE+"Hello from the main thread.");

      final Thread anotherThread = new AnotherThread();
      anotherThread.setName("== Another Thread ==");
      anotherThread.start();

      new Thread() {
         public void run() {
            System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
         }
      }.start();

      Thread myRunnableThread = new Thread(new MyRunnable() {
         @Override
         public void run() {
            System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
            try {
               anotherThread.join();
               System.out.println(ANSI_RED + "AnotherThread terminated, or timed out, so I'm running again");
            } catch(InterruptedException e) {
               System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted");
            }
         }
      });

      myRunnableThread.start();

      System.out.println(ANSI_PURPLE+"Hello again from the main thread.");


   }
}

//output
//Hello from the main thread.
//        Hello again from the main thread.
//        Hello from the anonymous class thread
//Hello from the anonymous class's implementation of run()
//        Hello from == Another Thread ==
//        Three seconds have passed and I'm awake
//        AnotherThread terminated, or timed out, so I'm running again