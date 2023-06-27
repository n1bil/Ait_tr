package main.lesson_20.homework;

import main.lesson_20.homework.computer.model.Computer;
import main.lesson_20.homework.computer.model.Laptop;
import main.lesson_20.homework.computer.dao.ComputerHardwareStore;
import main.lesson_20.homework.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        ComputerHardwareStore computers = new ComputerHardwareStore(10);
        computers.addComputer(new Computer(5623231241287L, "I5", 8, 256, "Samsung"));
        computers.addComputer(new Computer(5423631841187L, "I7", 4, 256, "HP"));
        computers.addComputer(new Laptop(2473655343667L, "I7", 8, 128, "Toshiba", 8, 3));
        computers.addComputer(new Laptop(6473655333697L, "I7", 4, 512, "Asus", 7, 2.3));
        computers.addComputer(new Smartphone(7473655377667L, "Snapdragon", 8, 64, "Xiaomi", 8, 1.5, 12312332));
        System.out.println(computers.getSize());

        computers.addComputer(new Smartphone(7473655377669L, "Snapdragon", 6, 128, "Nokia", 10, 1.7, 34123123));
        System.out.println(computers.getSize());
        computers.printComputers();
        Computer computer = computers.findComputer(5423631841187L);
        System.out.println(computer);

        computers.removeComputer(5423631841187L);
        System.out.println(computers.getSize());
        computers.printComputers();
    }
}