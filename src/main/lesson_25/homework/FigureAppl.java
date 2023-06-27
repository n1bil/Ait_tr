package main.lesson_25.homework;

public class FigureAppl {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(3);
        shapes[1] = new Circle(4);
        shapes[2] = new Triangle(3);
        shapes[3] = new Square(4);

        System.out.println("Total area = " + calculateTotalArea(shapes));
        System.out.println("Total perimeter = " + calculateTotalPerimeter(shapes));
        System.out.println("Total area of circles = " + calculateTotalAreaOfCircles(shapes));
    }

    private static double calculateTotalPerimeter(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            sum += shapes[i].calcPerimeter();
        }
        return sum;
    }

    private static double calculateTotalArea(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            sum += shapes[i].calcArea();
        }
        return sum;
    }

    private static double calculateTotalAreaOfCircles(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Circle) {
                sum += shapes[i].calcArea();
            }
        }
        return sum;
    }
}
