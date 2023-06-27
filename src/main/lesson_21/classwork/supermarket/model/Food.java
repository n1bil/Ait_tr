package main.lesson_21.classwork.supermarket.model;

public class Food extends Product {

    private double kg;

    public Food(int barCode, String name, double price, double kg) {
        super(barCode, name, price);
        this.kg = kg;
    }

    @Override
    public String toString() {
        return "Food{" +
                "barCode=" + barCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", price=" + kg +
                '}';
    }
}
