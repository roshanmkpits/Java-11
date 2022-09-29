package ch14_11.iobinary;

// take integer as an input
//display in binary format
//last 8 digit of binary shown in colour
public class Ch14_bindemo {

        private static final String ANSI_RESET = "\u001B[0m";
        private static final String ANSI_BLACK = "\u001B[30m";
        private static final String ANSI_RED = "\u001B[31m";
        private static final String ANSI_GREEN = "\u001B[32m";
        private static final String ANSI_YELLOW = "\u001B[33m";
        private static final String ANSI_BLUE = "\u001B[34m";
        private static final String ANSI_PURPLE = "\u001B[35m";
        private static final String ANSI_CYAN = "\u001B[36m";
        private static final String ANSI_WHITE = "\u001B[37m";

        public static void main(String[] args) {
            int x = 922342959;

            writeInt(x);
        }


        private static void display(int x) {
            String all = String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
            String colouredBinary = all.substring(0, 24) + ANSI_PURPLE + all.substring(24) + ANSI_RESET;
            int y = x & 0xFF;
            String output = String.format("%10d and 0xFF is %8s \t %10d is ",  y, Integer.toBinaryString(y), x) + colouredBinary;
            System.out.println(output);
        }

        private static void writeInt(int v) {
            int x;
            display(v >>> 24);
            display(v >>> 16);
            display(v >>> 8);
            display(v >>> 0);
        }
    }

//output
                                                 //last 8 bit represent binary
//54 and 0xFF is   110110 	               54 is 00000000000000000000000000110110
//        249 and 0xFF is 11111001 	      14073 is 00000000000000000011011011111001
//        214 and 0xFF is 11010110 	    3602902 is 00000000001101101111100111010110
//        47 and 0xFF is   101111 	  922342959 is 00110110111110011101011000101111