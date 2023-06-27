package main.lesson_25.homework;

public class Triangle extends Shape {

    public Triangle(double side) {
        super(side);
    }

    @Override
    public double calcArea() {
        return getSide() * getSide() * Math.sqrt(3) / 4;
    }

    @Override
    public double calcPerimeter() {
        return getSide() * 3;
    }
}
