package main.lesson_21.homework.supermarket.model;

public class Product {

    protected final int barCode;
    protected String name;
    protected double price;

    public Product(int barCode, String name, double price) {
        this.barCode = barCode;
        this.name = name;
        this.price = price;
    }

    public int getBarCode() {
        return barCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "barCode=" + barCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return barCode == product.barCode;
    }
}
