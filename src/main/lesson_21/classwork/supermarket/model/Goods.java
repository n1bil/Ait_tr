package main.lesson_21.classwork.supermarket.model;

public class Goods extends Product {

    private String color;

    public Goods(int barCode, String name, double price, String color) {
        super(barCode, name, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "barCode=" + barCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", price=" + color +
                '}';
    }
}
