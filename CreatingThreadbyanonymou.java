package thread2.anonymes;



//thread color class  is used to display output in color
//creating a thread by anonymous
//display a message by thread



import static thread2.anonymes.ThreadColor.ANSI_GREEN;

class ThreadColor {
   public static final String ANSI_RESET = "\u001B[0m";
   public static final String ANSI_BLACK = "\u001B[30m";
   public static final String ANSI_RED = "\u001B[31m";
   public static final String ANSI_GREEN = "\u001B[32m";
   public static final String ANSI_BLUE = "\u001B[34m";
   public static final String ANSI_PURPLE = "\u001B[35m";
   public static final String ANSI_CYAN = "\u001B[36m";
}

public class CreatingThreadbyanonymou {
   public static void main(String[] args) {


      new Thread() {
         public void run() {
            System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
         }
      }.start();

   }
}

//output
//Hello from the anonymous class thread