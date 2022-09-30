package filesystem4.filevisitor;


import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
//example of simple filevisitor
//overide SimpleFileVisitor method
class PrintNames extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}

public class FileVisitor {
    public static void main(String[] args) {

        System.out.println("---Walking Tree for Dir2---");
        Path dir2Path = FileSystems.getDefault().getPath("Examples" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }

    }

//output
//---Walking Tree for Dir2---
//        G:\java11Prog\nionew\Examples\Dir2
//        G:\java11Prog\nionew\Examples\Dir2\Dir3
//        G:\java11Prog\nionew\Examples\Dir2\Dir3\file1.txt
//        G:\java11Prog\nionew\Examples\Dir2\Dir3\file2.txt
//        G:\java11Prog\nionew\Examples\Dir2\file1.txt
//        G:\java11Prog\nionew\Examples\Dir2\file2.txt
//        G:\java11Prog\nionew\Examples\Dir2\file3.txt