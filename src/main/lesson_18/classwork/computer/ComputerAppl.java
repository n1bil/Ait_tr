package main.lesson_18.classwork.computer;

import main.lesson_18.classwork.computer.model.Computer;
import main.lesson_18.classwork.computer.model.Laptop;
import main.lesson_18.classwork.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        Computer[] computers = new Computer[3];
        computers[0] = new Computer("I5", 12, 512, "HP");
        computers[1] = new Laptop("I7", 16, 512, "Asus", 2.5, 2.1);
        computers[2] = new Smartphone("Snapdragon", 8, 128, "Samsung", 8, 2.1, 123456789098L);

        printArray(computers);
        int total = getTotalSSDCapacity(computers);
        System.out.println("Total ssd capacity = " + total);
        if (computers[1] instanceof Laptop) {
            Laptop laptop = (Laptop) computers[1];
            System.out.println(laptop.getHours());
            laptop.setRam(20);
            System.out.println(laptop);
            System.out.println(computers[1]);
        }
        if (computers[2] instanceof Laptop) {
            Laptop smartphone = (Laptop) computers[2];
            System.out.println(smartphone.getHours());
        }
        if (computers[0] instanceof Laptop) {           // false, потому что компьютер не может быть ноутбуком
            Laptop computer = (Laptop) computers[0];
            System.out.println(computer.getCpu());
        }
        double totalHours = getTotalHours(computers);
        System.out.println("Total hours = " + totalHours);
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

    public static double getTotalHours(Computer[] array) {
        double result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Laptop) {
                Laptop laptop = (Laptop) array[i];
                result += laptop.getHours();
            }
        }
        return result;
    }
}

















