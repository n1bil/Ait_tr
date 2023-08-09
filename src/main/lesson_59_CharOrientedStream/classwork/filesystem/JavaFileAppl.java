package main.lesson_59_CharOrientedStream.classwork.filesystem;

import java.io.File;

public class JavaFileAppl {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        String path = File.separator + "Users" + File.separator + "Admin" + File.separator + "Documents";
        System.out.println(path);
        File file = new File(path);
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getName());
        System.out.println("=====================");
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getName());
        }
        String newPath = path + File.separator + "my";
        File newFile = new File(newPath);
        System.out.println(newFile.exists());
        newFile.mkdir();
        System.out.println(newFile.isDirectory());
        newFile.delete();
        System.out.println(newFile.exists());
    }
}
