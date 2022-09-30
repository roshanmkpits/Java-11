package nio9.readwitedatathread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;


//modification in existing program
//program using pipe to send data from one thread to another
//to write data pipe.sink
//to read data pipe .source

public class PipeWithThreadNio14_8 {
    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i=0; i<10; i++) {
                            String currentTime = "The time is: " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while(buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);

                        }

                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            };


            Runnable reader = new Runnable() {
                @Override
                public void run() {

                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i=0; i<10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }

                    } catch(Exception e) {
                        e.printStackTrace();
                    }

                }
            };

            new Thread(writer).start();
            new Thread(reader).start();

        } catch(IOException e) {
            e.printStackTrace();
        }


        }
    }
//}


//output
//Reader Thread: The time is: 1664521768056
//        Reader Thread: The time is: 1664521768201
//        Reader Thread: The time is: 1664521768312
//        Reader Thread: The time is: 1664521768419
//        Reader Thread: The time is: 1664521768527
//        Reader Thread: The time is: 1664521768638
//        Reader Thread: The time is: 1664521768746
//        Reader Thread: The time is: 1664521768857
//        Reader Thread: The time is: 1664521768966
//        Reader Thread: The time is: 1664521769076