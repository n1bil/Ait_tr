package main.lesson_11.homework;

import java.util.Arrays;

public class Dumpling {
    public static void main(String[] args) {
        dumplings();

        int[] array = {10, 20, 11, 22, 35, 15};
        int index = binarySearch(array, 35, 0, array.length - 1);
        System.out.println("Index: " + index);
        System.out.println("Element: " + array[index]);

        selectionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    // task 1
    public static int binarySearch(int[] array, int key, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // task 2
    public static void dumplings() {
        int[] pelmeni = new int[30];                                    // бабушка налепила 30 пельмешек
        for (int i = 0; i < pelmeni.length; i++) {
            pelmeni[12] = 15;                                           // бабушка положила монету в 7 пельмень и стал весить на 15 г. больше
            int i1 = pelmeni[i] + 100;                                  // каждому пельмешку добавляем 100г(стандартный вес пельмешка)
            if (i1 > 100) {                                             // если пельмешек весит больше стандартного
                System.out.println("Coin in " + i + " dumpling");       // вывести индекс пельмешка
            }
        }
    }

    // task 3
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }
}















