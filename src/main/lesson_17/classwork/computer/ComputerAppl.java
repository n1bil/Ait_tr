package main.lesson_17.classwork.computer;

import main.lesson_17.classwork.computer.model.Computer;
import main.lesson_17.classwork.computer.model.Laptop;
import main.lesson_17.classwork.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        Computer[] computers = new Computer[3];
        computers[0] = new Computer("I5", 12, 512, "HP");
        computers[1] = new Laptop("I7", 16, 512, "Asus", 2.5, 2.1);
        computers[2] = new Smartphone("Snapdragon", 8, 128, "Samsung", 8, 2.1, 123456789098L);

        printArray(computers);
        int total = getTotalSSDCapacity(computers);
        System.out.println("Total ssd capacity = " + total);
//        System.out.println(computers[1].getHours());
//        System.out.println(computers[2].getHours());
    }

    public static int getTotalSSDCapacity(Computer[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i].getSsd();
        }
        return result;
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
