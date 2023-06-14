package main.lesson_19.classwork;

import main.lesson_19.classwork.computer.model.Computer;
import main.lesson_19.classwork.computer.model.Laptop;
import main.lesson_19.classwork.computer.model.Smartphone;

import java.util.Scanner;

public class ComputerCompareAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Computer computer1 = new Computer("I5", 12, 512, "HP");
        System.out.print("Enter CPU: ");
        String cpu = scanner.nextLine();
        System.out.print("Enter RAM: ");
        int ram = scanner.nextInt();
        System.out.print("Enter SSD: ");
        int ssd = scanner.nextInt();
        System.out.print("Enter brand: ");
        String brand = scanner.next();
        Computer computer2 = new Computer(cpu, ram, ssd, brand);
        Computer computer3 = new Computer("I5", 12, 512, "HP");
        System.out.println(computer1);
        System.out.println(computer2);
        System.out.println(computer3);
        System.out.println(computer1.equals(computer2));
        System.out.println(computer1.equals(computer3));
        System.out.println(computer3.equals(computer2));
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
