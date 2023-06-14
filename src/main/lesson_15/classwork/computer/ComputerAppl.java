package main.lesson_15.classwork.computer;

import main.lesson_15.classwork.computer.model.Computer;
import main.lesson_15.classwork.computer.model.Laptop;
import main.lesson_15.classwork.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        Computer computer1 = new Computer("I5", 12, 512, "HP");
        Laptop laptop1 = new Laptop("I7", 16, 512, "Asus", 2.5, 2.1);
        Smartphone smartphone1 = new Smartphone("Snapdragon", 8, 128, "Samsung", 8, 2.1, 123456789098L);
        computer1.display();
        System.out.println();
        laptop1.display();
        System.out.println();
        smartphone1.display();
    }
}
