package main.lesson_10.classwork;

import java.util.Random;

public class ArrayAdvanced {
    public static void main(String[] args) {
        int[] arr = new int[10];
        printArray(arr);
        fillArray(arr, 10, 99);
        printArray(arr);

        swapFirstLast(arr);
        printArray(arr);

        int index = search(arr, 42);
        System.out.println("Index = " + index);

        System.out.println(maxArray(arr));
    }

    public static void fillArray(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (min + Math.random() * (max + 1 - min));
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void swapFirstLast(int[] arr) {
        int t = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = t;
    }

    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int maxArray(int[] array) {
        int maxArray = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxArray) {
                maxArray = array[i];
            }
        }
        return maxArray;
    }
}












