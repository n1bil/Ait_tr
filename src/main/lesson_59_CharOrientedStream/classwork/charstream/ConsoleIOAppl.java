package main.lesson_59_CharOrientedStream.classwork.charstream;

import java.io.*;

public class ConsoleIOAppl {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));       // analogue scanner
        PrintWriter console = new PrintWriter(System.out, true);
//        System.out.println("Enter file name:");
        console.println("Enter file name:");
//        console.flush();
        String str = reader.readLine();
        PrintWriter printWriter = new PrintWriter(new FileWriter(str, true));        // if true then append
        System.out.println("Please write your text here:");
        str = reader.readLine();
        while (!str.equalsIgnoreCase("exit")) {
            printWriter.println(str);
            printWriter.flush();
            System.out.println("Please write your text here:");
            str = reader.readLine();
        }
//        printWriter.flush();        // слить в файл
//        printWriter.close();
        console.close();
    }
}
