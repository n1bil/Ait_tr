package main.lesson_11.classwork;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Binary search");

        Scanner scanner = new Scanner(System.in);
        int element = scanner.nextInt();    // read searched element from user

        int[] numbers = {-4, 1, 10, 11, 13, 20, 35, 46, 56, 67};
        System.out.println(Arrays.toString(numbers));

        // Алгоритм:
        // left - левый конец массива (index)
        // right - правый конец массива (index)
        // middle - середина массива, middle = left + (right - left) / 2;
        // пока левый <= правый будем делать
        // искать элемент в левой или правой половине ?
        // "сделать" новые left и right в зависимости от того, где оказался искомый элемент

        int left = 0;
        int right = numbers.length - 1;
        int mid = left + (right - left) / 2;
        boolean hasElement = false;

        while (left <= right) {
            if (element < numbers[mid]) {        // element in left part
                right = mid - 1;
            } else if (element > numbers[mid]) { // element in part part
                left = mid + 1;
            } else {                             // element is found
                hasElement = true;
                break;
            }

            mid = left + (right - left) / 2; // new middle
        }
        System.out.println("Search result = " + hasElement);
    }
}
