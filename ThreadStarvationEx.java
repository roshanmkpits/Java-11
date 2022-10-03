package thread17.thstarvation;



//thread starvation occurred in case of priority
// in this example 5 thread is created with diffrent priority




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
 class Worker implements Runnable {
     private static Object lock = new Object();
    private int runCount = 1;
    private String threadColor;

    public Worker(String threadColor) {
        this.threadColor = threadColor;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            synchronized (lock) {
                System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                // execute critial section of code
            }
        }
    }
}




public class ThreadStarvationEx {


    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t3.start();
        t2.start();
        t5.start();
        t4.start();
        t1.start();

    }
}

//output
//Priority 6: runCount = 1
//        Priority 6: runCount = 2
//        Priority 6: runCount = 3
//        Priority 6: runCount = 4
//        Priority 6: runCount = 5
//        Priority 6: runCount = 6
//        Priority 6: runCount = 7
//        Priority 6: runCount = 8
//        Priority 6: runCount = 9
//        Priority 6: runCount = 10
//        Priority 6: runCount = 11
//        Priority 6: runCount = 12
//        Priority 6: runCount = 13
//        Priority 6: runCount = 14
//        Priority 6: runCount = 15
//        Priority 6: runCount = 16
//        Priority 6: runCount = 17
//        Priority 6: runCount = 18
//        Priority 6: runCount = 19
//        Priority 6: runCount = 20
//        Priority 6: runCount = 21
//        Priority 6: runCount = 22
//        Priority 6: runCount = 23
//        Priority 6: runCount = 24
//        Priority 6: runCount = 25
//        Priority 6: runCount = 26
//        Priority 6: runCount = 27
//        Priority 6: runCount = 28
//        Priority 6: runCount = 29
//        Priority 6: runCount = 30
//        Priority 6: runCount = 31
//        Priority 6: runCount = 32
//        Priority 2: runCount = 1
//        Priority 2: runCount = 2
//        Priority 2: runCount = 3
//        Priority 2: runCount = 4
//        Priority 2: runCount = 5
//        Priority 2: runCount = 6
//        Priority 2: runCount = 7
//        Priority 2: runCount = 8
//        Priority 2: runCount = 9
//        Priority 2: runCount = 10
//        Priority 2: runCount = 11
//        Priority 2: runCount = 12
//        Priority 2: runCount = 13
//        Priority 2: runCount = 14
//        Priority 2: runCount = 15
//        Priority 2: runCount = 16
//        Priority 2: runCount = 17
//        Priority 2: runCount = 18
//        Priority 2: runCount = 19
//        Priority 2: runCount = 20
//        Priority 2: runCount = 21
//        Priority 2: runCount = 22
//        Priority 2: runCount = 23
//        Priority 2: runCount = 24
//        Priority 2: runCount = 25
//        Priority 2: runCount = 26
//        Priority 2: runCount = 27
//        Priority 2: runCount = 28
//        Priority 2: runCount = 29
//        Priority 2: runCount = 30
//        Priority 2: runCount = 31
//        Priority 2: runCount = 32
//        Priority 2: runCount = 33
//        Priority 2: runCount = 34
//        Priority 2: runCount = 35
//        Priority 2: runCount = 36
//        Priority 2: runCount = 37
//        Priority 2: runCount = 38
//        Priority 2: runCount = 39
//        Priority 2: runCount = 40
//        Priority 2: runCount = 41
//        Priority 2: runCount = 42
//        Priority 2: runCount = 43
//        Priority 2: runCount = 44
//        Priority 2: runCount = 45
//        Priority 2: runCount = 46
//        Priority 2: runCount = 47
//        Priority 2: runCount = 48
//        Priority 2: runCount = 49
//        Priority 2: runCount = 50
//        Priority 2: runCount = 51
//        Priority 2: runCount = 52
//        Priority 2: runCount = 53
//        Priority 2: runCount = 54
//        Priority 2: runCount = 55
//        Priority 2: runCount = 56
//        Priority 2: runCount = 57
//        Priority 2: runCount = 58
//        Priority 2: runCount = 59
//        Priority 2: runCount = 60
//        Priority 2: runCount = 61
//        Priority 2: runCount = 62
//        Priority 2: runCount = 63
//        Priority 2: runCount = 64
//        Priority 2: runCount = 65
//        Priority 2: runCount = 66
//        Priority 2: runCount = 67
//        Priority 2: runCount = 68
//        Priority 2: runCount = 69
//        Priority 2: runCount = 70
//        Priority 2: runCount = 71
//        Priority 2: runCount = 72
//        Priority 2: runCount = 73
//        Priority 2: runCount = 74
//        Priority 2: runCount = 75
//        Priority 2: runCount = 76
//        Priority 2: runCount = 77
//        Priority 2: runCount = 78
//        Priority 2: runCount = 79
//        Priority 2: runCount = 80
//        Priority 2: runCount = 81
//        Priority 2: runCount = 82
//        Priority 2: runCount = 83
//        Priority 2: runCount = 84
//        Priority 2: runCount = 85
//        Priority 2: runCount = 86
//        Priority 2: runCount = 87
//        Priority 2: runCount = 88
//        Priority 2: runCount = 89
//        Priority 2: runCount = 90
//        Priority 2: runCount = 91
//        Priority 2: runCount = 92
//        Priority 2: runCount = 93
//        Priority 2: runCount = 94
//        Priority 2: runCount = 95
//        Priority 2: runCount = 96
//        Priority 2: runCount = 97
//        Priority 2: runCount = 98
//        Priority 2: runCount = 99
//        Priority 2: runCount = 100
//        Priority 4: runCount = 1
//        Priority 4: runCount = 2
//        Priority 4: runCount = 3
//        Priority 4: runCount = 4
//        Priority 4: runCount = 5
//        Priority 4: runCount = 6
//        Priority 4: runCount = 7
//        Priority 4: runCount = 8
//        Priority 4: runCount = 9
//        Priority 4: runCount = 10
//        Priority 4: runCount = 11
//        Priority 4: runCount = 12
//        Priority 4: runCount = 13
//        Priority 4: runCount = 14
//        Priority 4: runCount = 15
//        Priority 4: runCount = 16
//        Priority 4: runCount = 17
//        Priority 4: runCount = 18
//        Priority 4: runCount = 19
//        Priority 4: runCount = 20
//        Priority 4: runCount = 21
//        Priority 4: runCount = 22
//        Priority 4: runCount = 23
//        Priority 4: runCount = 24
//        Priority 4: runCount = 25
//        Priority 4: runCount = 26
//        Priority 4: runCount = 27
//        Priority 4: runCount = 28
//        Priority 4: runCount = 29
//        Priority 4: runCount = 30
//        Priority 4: runCount = 31
//        Priority 4: runCount = 32
//        Priority 4: runCount = 33
//        Priority 4: runCount = 34
//        Priority 4: runCount = 35
//        Priority 4: runCount = 36
//        Priority 4: runCount = 37
//        Priority 4: runCount = 38
//        Priority 4: runCount = 39
//        Priority 4: runCount = 40
//        Priority 4: runCount = 41
//        Priority 4: runCount = 42
//        Priority 4: runCount = 43
//        Priority 4: runCount = 44
//        Priority 4: runCount = 45
//        Priority 4: runCount = 46
//        Priority 4: runCount = 47
//        Priority 4: runCount = 48
//        Priority 4: runCount = 49
//        Priority 4: runCount = 50
//        Priority 4: runCount = 51
//        Priority 4: runCount = 52
//        Priority 4: runCount = 53
//        Priority 4: runCount = 54
//        Priority 4: runCount = 55
//        Priority 4: runCount = 56
//        Priority 4: runCount = 57
//        Priority 4: runCount = 58
//        Priority 4: runCount = 59
//        Priority 4: runCount = 60
//        Priority 4: runCount = 61
//        Priority 4: runCount = 62
//        Priority 4: runCount = 63
//        Priority 4: runCount = 64
//        Priority 4: runCount = 65
//        Priority 4: runCount = 66
//        Priority 4: runCount = 67
//        Priority 4: runCount = 68
//        Priority 4: runCount = 69
//        Priority 4: runCount = 70
//        Priority 4: runCount = 71
//        Priority 4: runCount = 72
//        Priority 4: runCount = 73
//        Priority 4: runCount = 74
//        Priority 4: runCount = 75
//        Priority 4: runCount = 76
//        Priority 4: runCount = 77
//        Priority 4: runCount = 78
//        Priority 4: runCount = 79
//        Priority 4: runCount = 80
//        Priority 4: runCount = 81
//        Priority 4: runCount = 82
//        Priority 4: runCount = 83
//        Priority 4: runCount = 84
//        Priority 4: runCount = 85
//        Priority 4: runCount = 86
//        Priority 4: runCount = 87
//        Priority 4: runCount = 88
//        Priority 4: runCount = 89
//        Priority 4: runCount = 90
//        Priority 4: runCount = 91
//        Priority 4: runCount = 92
//        Priority 4: runCount = 93
//        Priority 4: runCount = 94
//        Priority 4: runCount = 95
//        Priority 4: runCount = 96
//        Priority 4: runCount = 97
//        Priority 4: runCount = 98
//        Priority 4: runCount = 99
//        Priority 4: runCount = 100
//        Priority 10: runCount = 1
//        Priority 10: runCount = 2
//        Priority 10: runCount = 3
//        Priority 10: runCount = 4
//        Priority 10: runCount = 5
//        Priority 10: runCount = 6
//        Priority 10: runCount = 7
//        Priority 10: runCount = 8
//        Priority 10: runCount = 9
//        Priority 10: runCount = 10
//        Priority 10: runCount = 11
//        Priority 10: runCount = 12
//        Priority 10: runCount = 13
//        Priority 10: runCount = 14
//        Priority 10: runCount = 15
//        Priority 10: runCount = 16
//        Priority 10: runCount = 17
//        Priority 10: runCount = 18
//        Priority 10: runCount = 19
//        Priority 10: runCount = 20
//        Priority 10: runCount = 21
//        Priority 10: runCount = 22
//        Priority 10: runCount = 23
//        Priority 10: runCount = 24
//        Priority 10: runCount = 25
//        Priority 10: runCount = 26
//        Priority 10: runCount = 27
//        Priority 10: runCount = 28
//        Priority 10: runCount = 29
//        Priority 10: runCount = 30
//        Priority 10: runCount = 31
//        Priority 10: runCount = 32
//        Priority 10: runCount = 33
//        Priority 10: runCount = 34
//        Priority 10: runCount = 35
//        Priority 10: runCount = 36
//        Priority 10: runCount = 37
//        Priority 10: runCount = 38
//        Priority 10: runCount = 39
//        Priority 10: runCount = 40
//        Priority 10: runCount = 41
//        Priority 10: runCount = 42
//        Priority 10: runCount = 43
//        Priority 10: runCount = 44
//        Priority 10: runCount = 45
//        Priority 10: runCount = 46
//        Priority 10: runCount = 47
//        Priority 10: runCount = 48
//        Priority 10: runCount = 49
//        Priority 10: runCount = 50
//        Priority 10: runCount = 51
//        Priority 10: runCount = 52
//        Priority 10: runCount = 53
//        Priority 10: runCount = 54
//        Priority 10: runCount = 55
//        Priority 10: runCount = 56
//        Priority 10: runCount = 57
//        Priority 10: runCount = 58
//        Priority 10: runCount = 59
//        Priority 10: runCount = 60
//        Priority 10: runCount = 61
//        Priority 10: runCount = 62
//        Priority 10: runCount = 63
//        Priority 10: runCount = 64
//        Priority 10: runCount = 65
//        Priority 10: runCount = 66
//        Priority 10: runCount = 67
//        Priority 10: runCount = 68
//        Priority 10: runCount = 69
//        Priority 10: runCount = 70
//        Priority 10: runCount = 71
//        Priority 10: runCount = 72
//        Priority 10: runCount = 73
//        Priority 10: runCount = 74
//        Priority 10: runCount = 75
//        Priority 10: runCount = 76
//        Priority 10: runCount = 77
//        Priority 10: runCount = 78
//        Priority 10: runCount = 79
//        Priority 10: runCount = 80
//        Priority 10: runCount = 81
//        Priority 10: runCount = 82
//        Priority 10: runCount = 83
//        Priority 10: runCount = 84
//        Priority 10: runCount = 85
//        Priority 10: runCount = 86
//        Priority 10: runCount = 87
//        Priority 10: runCount = 88
//        Priority 10: runCount = 89
//        Priority 10: runCount = 90
//        Priority 10: runCount = 91
//        Priority 10: runCount = 92
//        Priority 10: runCount = 93
//        Priority 10: runCount = 94
//        Priority 10: runCount = 95
//        Priority 10: runCount = 96
//        Priority 10: runCount = 97
//        Priority 10: runCount = 98
//        Priority 10: runCount = 99
//        Priority 10: runCount = 100
//        Priority 8: runCount = 1
//        Priority 8: runCount = 2
//        Priority 8: runCount = 3
//        Priority 8: runCount = 4
//        Priority 8: runCount = 5
//        Priority 8: runCount = 6
//        Priority 8: runCount = 7
//        Priority 8: runCount = 8
//        Priority 8: runCount = 9
//        Priority 8: runCount = 10
//        Priority 8: runCount = 11
//        Priority 8: runCount = 12
//        Priority 8: runCount = 13
//        Priority 8: runCount = 14
//        Priority 8: runCount = 15
//        Priority 8: runCount = 16
//        Priority 8: runCount = 17
//        Priority 8: runCount = 18
//        Priority 8: runCount = 19
//        Priority 8: runCount = 20
//        Priority 8: runCount = 21
//        Priority 8: runCount = 22
//        Priority 8: runCount = 23
//        Priority 8: runCount = 24
//        Priority 8: runCount = 25
//        Priority 8: runCount = 26
//        Priority 8: runCount = 27
//        Priority 8: runCount = 28
//        Priority 8: runCount = 29
//        Priority 8: runCount = 30
//        Priority 8: runCount = 31
//        Priority 8: runCount = 32
//        Priority 8: runCount = 33
//        Priority 8: runCount = 34
//        Priority 8: runCount = 35
//        Priority 8: runCount = 36
//        Priority 8: runCount = 37
//        Priority 8: runCount = 38
//        Priority 8: runCount = 39
//        Priority 8: runCount = 40
//        Priority 8: runCount = 41
//        Priority 8: runCount = 42
//        Priority 8: runCount = 43
//        Priority 8: runCount = 44
//        Priority 8: runCount = 45
//        Priority 8: runCount = 46
//        Priority 8: runCount = 47
//        Priority 8: runCount = 48
//        Priority 8: runCount = 49
//        Priority 8: runCount = 50
//        Priority 8: runCount = 51
//        Priority 8: runCount = 52
//        Priority 8: runCount = 53
//        Priority 8: runCount = 54
//        Priority 8: runCount = 55
//        Priority 8: runCount = 56
//        Priority 8: runCount = 57
//        Priority 8: runCount = 58
//        Priority 8: runCount = 59
//        Priority 8: runCount = 60
//        Priority 8: runCount = 61
//        Priority 8: runCount = 62
//        Priority 8: runCount = 63
//        Priority 8: runCount = 64
//        Priority 8: runCount = 65
//        Priority 8: runCount = 66
//        Priority 8: runCount = 67
//        Priority 8: runCount = 68
//        Priority 8: runCount = 69
//        Priority 8: runCount = 70
//        Priority 8: runCount = 71
//        Priority 8: runCount = 72
//        Priority 8: runCount = 73
//        Priority 8: runCount = 74
//        Priority 8: runCount = 75
//        Priority 8: runCount = 76
//        Priority 8: runCount = 77
