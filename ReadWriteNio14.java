import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

//reading data using nio
//reading dta from file data.txt line by line
public class ReadWriteNio14 {
    public  static void main(String[] args) {
        try {

            Path dataPath = FileSystems.getDefault().getPath("data.txt");

            List<String> lines = Files.readAllLines(dataPath);
            for(String line : lines) {
                System.out.println(line);
            }

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
