package main.lesson_58_ByteIO.classwork.byteio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOutputAppl {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("src/main/lesson_58_ByteIO/classwork/byteio/files/test1")) {
//            FileOutputStream outputStream = new FileOutputStream("src/main/lesson_58_ByteIO/classwork/byteio/files/test1", true);
            outputStream.write(65);                                                                         // if true then we do to append
            outputStream.write(1);
            outputStream.write(27);
            outputStream.write(257);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
