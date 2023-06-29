package main.lesson_21.homework;

import main.lesson_21.homework.supermarket.Supermarket;
import main.lesson_21.homework.supermarket.model.Food;
import main.lesson_21.homework.supermarket.model.Goods;
import main.lesson_21.homework.supermarket.model.Product;

public class SupermarketAppl {
    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket(10);
        supermarket.addProduct(new Product(562432431, "kettle", 6.99));
        supermarket.addProduct(new Goods(312321312, "Wheel", 13.55, "black"));
        supermarket.addProduct(new Food(21321312, "chicken", 9.01, 3.5));
        supermarket.addProduct(new Food(21321312, "pork", 8.01, 4.5));

        supermarket.printComputers();

    }
}
