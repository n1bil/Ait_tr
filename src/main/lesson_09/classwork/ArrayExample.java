package main.lesson_09.classwork;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        int[] array = {7, 6, 7, 8, 11, 12, 8};
//        averageGrades(array);
//        reverseArray(array);

//        int[] array2 = {44, 12, 65, 44, 98, 19, 32, 62, 78, 22};
//        randomNumbers(array2);

        int[] array3 = {46, 13, 1, 10, 67, -4, 20, 56, 11, 35};
        System.out.println(Arrays.toString(array3));
        sortArray(array3);
    }

    // task 4
    public static void averageGrades(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(sum / array.length);
    }

    // task 5
    public static void reverseArray(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    // task 6
    public static void randomNumbers(int[] array) {
        Scanner user = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int digit = user.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (digit == array[i]) {
                System.out.println("Number " + digit + " under inder " + i);
            }
        }
    }

    // task 7
    public static void sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}





















