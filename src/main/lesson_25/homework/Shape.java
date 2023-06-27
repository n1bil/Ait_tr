package main.lesson_25.homework;

public abstract class Shape {
    private double side;

    public Shape(double side) {
        this.side = side;
    }

    public abstract double calcArea();

    public abstract double calcPerimeter();

    public double getSide() {
        return side;
    }
}
