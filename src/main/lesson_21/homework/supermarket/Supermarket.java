package main.lesson_21.homework.supermarket;

import main.lesson_21.homework.supermarket.model.Product;

public class Supermarket {

    private Product[] products;
    private int size;

    public Supermarket(int capacity) {
        products = new Product[capacity];
    }

    public boolean addProduct(Product product) {
        if (size == products.length || findProduct(product.getBarCode()) != null) {
            return false;
        }
        products[size] = product;
        size++;
        return true;
    }

    public int getSize() {
        return size;
    }

    public Product findProduct(long barCode) {
        for (int i = 0; i < size; i++) {
            if (products[i].getBarCode() == barCode) {
                return products[i];
            }
        }
        return null;
    }

    public void printComputers() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }
}
