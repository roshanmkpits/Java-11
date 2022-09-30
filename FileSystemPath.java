package filesystem1.path;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// get the path of files from system
// in java.nio  java.nio.file.Path  interface used
// collect absolute path of file
//print the content of file
//using printfile fun

public class FileSystemPath {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);
//        Path filePath = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");
        Path filePath = Paths.get(".", "files", "SubdirectoryFile.txt");
        printFile(filePath);
//        filePath = Paths.get("/Volumes/Production/Courses/Programs", "/JavaPrograms", "OutThere.txt");
////        filePath = Paths.get("D:\\", "Examples", OutThere.txt");
//        // D:\\Examples\\OutThere.txt
//        printFile(filePath);

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());
        // D:\Examples\.\subfolder\..\directory
        // D:\Examples\directory
//        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
//        System.out.println(path2.normalize().toAbsolutePath());
//        printFile(path2.normalize());


    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
//output

//    File within the working directory.
//        Lorem ipsum dolor sit amet, consectetur adipiscing elit.
//        Ut suscipit eu lectus non volutpat.
//        In consequat ac lacus vitae ornare.
//        Vestibulum cursus urna tellus, vitae placerat elit euismod in.
//        File within subdirectory.
//        In consequat ac lacus vitae ornare.
//        Vestibulum cursus urna tellus, vitae placerat elit euismod in.
//        Aliquam at lobortis lacus.
//        G:\java11Prog\nionew\.