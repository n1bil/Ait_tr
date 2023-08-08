package main.lesson_58_ByteIO.homework.byteio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompareAppl {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong number of arguments");
            return;
        }
        System.out.println("Source1 = " + args[0]);
        System.out.println("Source2 = " + args[1]);
        try (FileInputStream fileInputStream1 = new FileInputStream(args[0]); FileInputStream fileInputStream2 = new FileInputStream(args[1])) {
            int data1;
            int data2;
            boolean areEqual = true;
            do {
                data1 = fileInputStream1.read();
                data2 = fileInputStream2.read();

                if (data1 != data2) {
                    areEqual = false;
                    break;
                }
            } while (data1 != -1 && data2 != -1);

            if (areEqual) {
                System.out.println("Files are equal");
            } else {
                System.out.println("Files are not equal");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
