package main.lesson_05;

public class Calculator {
    public static void main(String[] args) {
        calculator(6, 2, 0);
    }

    public static void calculator(double value1, double value2, int operator) {
        switch (operator) {
            case 1:
                System.out.println(value1 + value2);
                break;
            case 2:
                System.out.println(value1 - value2);
                break;
            case 3:
                System.out.println(value1 * value2);
                break;
            case 4:
                System.out.println(value1 / value2);
                break;
            default:
                System.out.println("Incorrect value. Try again");
        }
    }
}
