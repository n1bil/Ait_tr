package main.lesson_12.classwork.ait.arrays.utils;

public class ArraysTools {
    public static int search(int[] arr, int value) { // в этом binary search делаем поиск по каждому элементу массива
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // если нет то сокращаем на 2
            if (arr[mid] == value) {
                return mid;
            }
            if (value > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int maxArray(int[] array) {
        int maxArray = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxArray) {
                maxArray = array[i];
            }
        }
        return maxArray;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {          // если первый элемент больше следующего
                    int temp = arr[j];              // то запиши во временную переменную
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr) {
        boolean flag = bubbling(arr);
        while (flag) {
            flag = bubbling(arr);
        }
        // while (bubbling(arr))
    }

    private static boolean bubbling(int[] arr) {
        boolean flag = false;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                flag = true;
            }
        }
        return flag;
    }

    public static void fillArray(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (min + Math.random() * (max + 1 - min));
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
