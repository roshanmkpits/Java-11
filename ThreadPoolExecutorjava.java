package thread15.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static thread12.interference.ThreadInterference.EOF;

//problem wit not threadsfe class like arraylist
//one producer thread
//with two consumer thread
//all sharing same array list
//implementation of thread pool concept
//using ExecutorService (managed thread by jvm)
class ThreadColor {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001b[37m";
}

class MyProducer implements  Runnable {
    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5"};

        for(String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.add(num);

                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");
        buffer.add("EOF");
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while(true) {
            if(buffer.isEmpty()) {
                continue;
            }
            if(buffer.get(0).equals(EOF)) {
                System.out.println(color + "Exiting");
                break;
            } else {
                System.out.println(color + "Removed " + buffer.remove(0));
            }
        }
    }
}


public class ThreadPoolExecutorjava {
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        executorService.shutdown();

    }

    public static final String EOF = "EOF";
}

//output
//Adding...1
//        Adding...2
//        Adding...3
//        Adding...4
//        Adding...5
//        Adding EOF and exiting...
//not finished execution