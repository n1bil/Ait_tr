package main.lesson_58_ByteIO.classwork.byteio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteInputAppl {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("src/main/lesson_58_ByteIO/classwork/byteio/files/test1")) {

//            System.out.println("Available = " + inputStream.available());
//            int data = inputStream.read();
//            System.out.println(data);
//            System.out.println("Available = " + inputStream.available());
//            data = inputStream.read();
//            System.out.println(data);
//            System.out.println("Available = " + inputStream.available());
//            data = inputStream.read();
//            System.out.println(data);
//            System.out.println("Available = " + inputStream.available());
//            data = inputStream.read();
//            System.out.println(data);
//            System.out.println("Available = " + inputStream.available());
//            data = inputStream.read();
//            System.out.println(data);
//            System.out.println("Available = " + inputStream.available());
            // Option 1
//            int a = inputStream.read();
//            while (a != -1) {
//                System.out.println(a);
//                a = inputStream.read();
//            }
            // Option 2
//            int length = inputStream.available();
//            for (int i = 0; i < length; i++) {
//                int data = inputStream.read();
//                System.out.println(data);
//            }
            // Option 3
            int length = inputStream.available();
            byte[] array = new byte[length];
            inputStream.read(array);
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
