package main.lesson_56.classworkHomework;

import main.lesson_56.classworkHomework.dao.Supermarket;
import main.lesson_56.classworkHomework.dao.SupermarketImpl;
import main.lesson_56.classworkHomework.model.Product;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Supermarket supermarket = new SupermarketImpl();

        // adding goods to the supermarket
        supermarket.addProduct(new Product(1, "Milk", "Dairy produce", "Brand A", 4.99, LocalDate.now().minusDays(4)));
        supermarket.addProduct(new Product(2, "Apple", "Fruit", "Brand B", 1.99, LocalDate.now().minusDays(1)));
        supermarket.addProduct(new Product(3, "Egg", "Dairy produce", "Brand A", 0.49, LocalDate.now().minusDays(8)));
        supermarket.addProduct(new Product(4, "Yogurt", "Dairy produce", "Brand C", 12.99, LocalDate.now().minusDays(7)));
        supermarket.addProduct(new Product(5, "Tomato", "Vegetables", "Brand B", 0.99, LocalDate.now().minusDays(2)));
        supermarket.addProduct(new Product(6, "Orange", "Fruit", "Brand A", 1.99, LocalDate.now().minusDays(1)));
        supermarket.addProduct(new Product(7, "Carrot", "Vegetables", "Brand D", 2.99, LocalDate.now().minusDays(10)));
        // cannot be added because such a product with such a barcode already exists
        supermarket.addProduct(new Product(5, "Yogurt", "Dairy produce", "Brand C", 12.99, LocalDate.now().plusDays(3)));

        // print all the products
        supermarket.forEach(System.out::println);

        System.out.println("=================================");

        // print all the products with expired date
        supermarket.findProductsWithExpiredDate().forEach(System.out::println);
    }
}