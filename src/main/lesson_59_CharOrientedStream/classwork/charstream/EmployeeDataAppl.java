package main.lesson_59_CharOrientedStream.classwork.charstream;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmployeeDataAppl {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/main/lesson_59_CharOrientedStream/charstream/employee.csv"))) {
            String str = bufferedReader.readLine();
//            System.out.println(str);
            String[] cells = str.split(",");
            printCells(cells);
            str = bufferedReader.readLine();
            int count = 0;
            double salary = 0;
            long age = 0;
            while (str != null) {
                count++;                                                        // total employee
                cells = str.split(",");
                salary += Double.parseDouble(cells[2]);                         // total salary
                LocalDate birthday = LocalDate.parse(cells[3]);
                age += ChronoUnit.YEARS.between(birthday, LocalDate.now());     // total age
                printCells(cells);
                str = bufferedReader.readLine();
            }
            System.out.println("Total employees = " + salary);
            System.out.println("Total salary = " + count);
            System.out.println("Average salary = " + salary / count);
            System.out.println("Average age = " + 1. * age / count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCells(String[] cells) {
        for (String str : cells) {
            System.out.print(str + "\t");
        }
        System.out.println();
    }
}
