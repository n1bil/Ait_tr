package main.lesson_12.homework;

import java.util.Scanner;

public class CalculatorAppl {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the first value: ");
        double value1 = keyboard.nextDouble();
        System.out.print("Enter the second value: ");
        double value2 = keyboard.nextDouble();
        System.out.print("Enter the operation: ");
        String operator = keyboard.next();


        double result = calculator(value1, value2, operator);
        System.out.println("Result = " + result);
    }

    public static double calculator(double x, double y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "/":
                return x / y;
            case "*":
                return x * y;
            default:
                // return 0. / 0;
                return 0;
        }
    }
}
