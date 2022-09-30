package nio_2.write;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

//reading data using java.nio.file.Files;
//writing data to file
//StandardOpenOption-append,create,read,write
public class ReadWriteNio14_2 {
    public  static void main(String[] args) {
        try {

            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.CREATE);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
//output
//Line 1
//        Line 2
//        Line 3
//        Line 4
//        Line 5
//
//        Line 5   :append in existing file