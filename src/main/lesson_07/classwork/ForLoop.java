package main.lesson_07.classwork;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
//        multiplicationTable();
//        tableOfSquaresOfNumbers();
        sumOfAllTheDigits();
//        bank();
    }

    // task 1
    // - Вывести на экран таблицу умножения

    // алгоритм
    // - цикл 1 будет перебирать числа от 1 до 9, параметр i=1 до 9, i++
    // - цикл 2 (вложенный) будет перебирать числа от 1 до 9, параметр j от 1 до 0, j++
    // внутри цикла печатаем результат умножения i * j
    public static void multiplicationTable() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                int product = i * j;
                System.out.printf("%2d ", product);         // если у нас есть число 5, то %2d приведет к выводу " 5"
            }
            System.out.println();                           //  %2d : % - символ форматирования
        }                                                   //  2 - число, указывающее ширину поля вывода
    }                                                       //  d - символ, обозначающий целочисленное значение (decimal)

    // task 2
    public static void tableOfSquaresOfNumbers() {
        for (int i = 1; i <= 100; i++) {
            int square = i * i;
            System.out.println("\t" + i + " * " + i + " = " + square);
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    // task 3
    public static void sumOfAllTheDigits() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = keyboard.nextInt();
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    // task 4
    public static void bank() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How much money do you want to deposit ? - ");
        int money = keyboard.nextInt();
        double bankDeposit = 0.15;
        System.out.print("For how many months do you want to deposit money ? - ");
        int months = keyboard.nextInt();
        double result = 0;
        System.out.println("You deposited $" + money + " in the bank");
        for (int i = 0; i < months; i++) {
            result += money * bankDeposit;
        }
        System.out.println("Your contribution for " + months + " months is: - $" + result);
    }
}

//  Полезно при отладке цикла:
//  - включить промежуточные печати параметра цикла и получаемого результата
//  - проверить при крайних значениях, а потом на 1-2 итерации самостоятельно (ручка, бумажка, калькулятор)












