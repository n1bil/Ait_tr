package main.lesson_25.homework;

public class Square extends Shape {

    public Square(double side) {
        super(side);
    }

    @Override
    public double calcArea() {
        return getSide() * getSide();
    }

    @Override
    public double calcPerimeter() {
        return getSide() * 4;
    }
}
