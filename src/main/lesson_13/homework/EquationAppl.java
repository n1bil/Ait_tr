package main.lesson_13.homework;

import main.lesson_13.homework.model.QuadraticEquation;

public class EquationAppl {
    public static void main(String[] args) {
        QuadraticEquation quadraticEquation1 = new QuadraticEquation(2, 5, 3);
        quadraticEquation1.display();

        QuadraticEquation quadraticEquation2 = new QuadraticEquation(1, 0, 4);
        quadraticEquation2.display();

        QuadraticEquation quadraticEquation3 = new QuadraticEquation(1, -8, 15);
        quadraticEquation3.display();
    }
}
