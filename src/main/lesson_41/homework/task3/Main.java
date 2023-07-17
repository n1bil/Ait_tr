package main.lesson_41.homework.task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        System.out.print("Enter the size of the list: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the surnames: ");
        for (int i = 0; i < size; i++) {
            String surname = scanner.nextLine();
            list.add(0, surname);
        }

        System.out.print("Surname list: ");
        for (String output : list) {
            System.out.print(output + " ");
        }
    }
}
