package main.lesson_40_ArrayList.classworkHomework.complexity;

import java.util.Arrays;

public class ComplexityAppl {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 7, 11, 13, 17, 19};

        // O(1) - constant complexity - 1
        double mid = (array[0] + array[array.length - 1] / 2);

        // O(n) - linear complexity - 3
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        // O(log(n)) - log - 2
        int index = Arrays.binarySearch(array, 10);

        // 0(n^2) - quadratic - 5
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // 0(n * log(n)) - polylinear - 4
        Arrays.sort(array);
    }
}
