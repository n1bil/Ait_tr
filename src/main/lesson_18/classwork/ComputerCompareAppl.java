package main.lesson_18.classwork;

import main.lesson_18.classwork.computer.model.Computer;
import main.lesson_18.classwork.computer.model.Laptop;
import main.lesson_18.classwork.computer.model.Smartphone;

public class ComputerCompareAppl {
    public static void main(String[] args) {
        Computer[] computers = new Computer[3];
        computers[0] = new Computer("I5", 12, 512, "HP");
        computers[1] = new Laptop("I7", 16, 512, "Asus", 2.5, 2.1);
        computers[2] = new Smartphone("Snapdragon", 8, 128, "Samsung", 8, 2.1, 123456789098L);

        printArray(computers);
        System.out.println("==========================================");
        Computer computer = new Computer("I5", 12, 512, "HP");
        boolean checker = computer.equals(computers[0]);
        System.out.println("Computer are " + checker);
        Laptop laptop = new Laptop("I7", 16, 512, "Panasonic", 2.5, 2.1);
        checker = laptop.equals(computers[1]);
        System.out.println("Laptop are " + checker);
        Smartphone smartphone = new Smartphone("Snapdragon", 8, 128, "Samsung", 8, 2.1, 123456789097L);
        checker = smartphone.equals(computers[2]);
        System.out.println("Smartphones are " + checker);
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
