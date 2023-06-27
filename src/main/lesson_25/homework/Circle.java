package main.lesson_25.homework;

public class Circle extends Shape {

    public Circle(double side) {
        super(side);
    }

    @Override
    public double calcArea() {
        return Math.PI * getSide() * getSide();
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * getSide();
    }
}
