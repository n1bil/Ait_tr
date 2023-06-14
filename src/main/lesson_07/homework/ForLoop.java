package main.lesson_07.homework;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
        // чтобы проверить задачу, расскоментируйте

//        sum();
//        multiplication();
//        bank();
//        compareFigures();
//        productOfTwoDigitOddNumbers();
        businessman(1000, 2000);
    }

    // task 0
    public static void sum() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int digit = console.nextInt();
        double sum = 0;
        for (double i = 1; i <= digit; i++) {
            sum = sum + 1 / i;
        }
        System.out.println(sum);
    }

    // task 1
    public static void multiplication() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int digit = console.nextInt();
        int sum = 1;
        for (int i = 1; i <= digit; i++) {
            sum *= i;
        }
        System.out.println(sum);
    }

    // task 2
    public static void bank() {
        Scanner console = new Scanner(System.in);
        System.out.print("How much money do you want to deposit ? - ");
        int money = console.nextInt();
        double bankDeposit = 0.03;
        System.out.print("For how many months do you want to deposit money ? - ");
        int months = console.nextInt();
        double result = 0;
        System.out.println("You deposited $" + money + " in the bank for " + months + " months");
        for (int i = 0; i < months; i++) {
            result += money * bankDeposit;
        }
        System.out.println("Your money plus " + months + " months deposit equals: - $" + (result + money));
    }

    // task 3
    public static void compareFigures() {
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter the first number: ");
            int number1 = console.nextInt();
            System.out.print("Enter the second number: ");
            int number2 = console.nextInt();
            if (number1 > number2) {
                System.out.println(number1 + " more than " + number2);
            } else if (number2 > number1) {
                System.out.println(number2 + " more than " + number1);
            } else {
                System.out.println("These numbers are equals");
            }
        }
    }

    // task 4
    public static void productOfTwoDigitOddNumbers() {
        for (int i = 10; i < 100; i++) {
            if (i % 2 == 1 && i % 13 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // task 5
    public static void businessman(double sum, int maxDebt) {
        double percent = 1.1;
        int counter = 0;
        if (sum < maxDebt) {
            while (sum < maxDebt) {
                counter++;
                sum = sum * percent;
            }
            System.out.println("You have accumulated the debt of $" + maxDebt + " over " + counter + " years");
        } else {
            System.out.println("Sum must be less than debt. Try again");
        }
    }
}



















