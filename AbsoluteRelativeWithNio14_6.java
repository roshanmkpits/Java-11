package nio6.abs_rel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//reading data from file using randomaccessfile with java.nio
//absolute read and relative read

public class AbsoluteRelativeWithNio14_6 {
    public static void main(String[] args) {

        try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()) {

            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was: " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            if(buffer.hasArray()) {
                System.out.println("byte buffer = " + new String(buffer.array()));
            }

//            // Absolute read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));


//             Relative read
//                        intBuffer.flip();
//                        numBytesRead = channel.read(intBuffer);
//                        intBuffer.flip();
//                        System.out.println(intBuffer.getInt());
//                        intBuffer.flip();
//                        numBytesRead = channel.read(intBuffer);
//                        intBuffer.flip();
//                        System.out.println(intBuffer.getInt());

            channel.close();
            ra.close();

//            System.out.println("outputBytes = " + new String(outputBytes));



        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
//output
//Relative read
//numBytes written was: 12
//        numBytes written was: 4
//        numBytes written was: 4
//        byte buffer = Hello World!
//        245
//        -98765

//output
//Absolute read
//numBytes written was: 12
//        numBytes written was: 4
//        numBytes written was: 4
//        byte buffer = Hello World!
//        245
//        -98765