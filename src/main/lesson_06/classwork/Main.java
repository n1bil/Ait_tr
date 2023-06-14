package main.lesson_06.classwork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input 1st number: ");
        double number1 = scanner.nextDouble();
        System.out.println("Input 2nd number: ");
        double number2 = scanner.nextDouble();

        System.out.println("Input operation: 1 - sum, 2 - subtraction, 3 - multiplication, 4 - division");
        int operation = scanner.nextInt();

        System.out.println("number1 = " + number1);
        System.out.println("number2 = " + number2);
        System.out.println("Operation = " + operation);

        switch (operation) {
            case 1: {
                double result = sum(number1, number2); // call the method
                System.out.println("Sum number1 and number2 = " + result);
                break;
            }
            case 2: {
                double result = subtraction(number1, number2);
                System.out.println("Subtraction number1 and number2 = " + result);
                break;
            }
            case 3: {
                double result = multiplication(number1, number2);
                System.out.println("Multiplication number1 and number2 = " + result);
                break;
            }
            case 4: {
                double result = division(number1, number2);
                System.out.println("Division number1 and number2 = " + result);
                break;
            }
        }
    }

    // ___________Methods____________
    public static double sum(double number1, double number2) {
        return number1 + number2;
    }

    public static double subtraction(double number1, double number2) {
        return number1 - number2;
    }

    public static double multiplication(double number1, double number2) {
        return number1 * number2;
    }

    public static double division(double number1, double number2) {
        return number1 / number2;
    }


    // ___________end of Methods_____________
}
