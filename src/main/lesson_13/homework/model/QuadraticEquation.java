package main.lesson_13.homework.model;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void display() {
        System.out.println("Discriminant: " + delta());
        System.out.println("Number of roots: " + quantityRoots());
    }

    public double delta() {
        return b * b - 4 * a * c;
    }

    public int quantityRoots() {
        if (delta() > 0) {
            return 2;
        } else if (delta() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}

