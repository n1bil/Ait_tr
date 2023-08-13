package main.lesson_61.classwork.restaurant.utils;

import main.lesson_61.classwork.restaurant.model.Table;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static DateTimeFormatter parseData() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public static void writeClientToFile(Table table) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/lesson_61/classwork/restaurant/file/File", true))) {
            writer.write(table.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
