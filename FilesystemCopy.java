package filesystem2.copyfile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

//copy data from file1.tsxt from example folder
//to file1copy,txt in example folder
//files.copy() function

public class FilesystemCopy {
    public static void main(String[] args) {
        try {
            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            Files.copy(sourceFile, copyFile);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}

