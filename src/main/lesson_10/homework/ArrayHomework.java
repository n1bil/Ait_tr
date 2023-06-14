package main.lesson_10.homework;

public class ArrayHomework {
    public static void main(String[] args) {
        int[] array = {7, 15, 17, 8, 11, 12, 8};
//        System.out.println("Index of the max element: " + indexOfTheMaxElement(array));
//        System.out.println("Average of elements: " + averageOfElements(array));
//        reverseArray(array);
    }

    // task 1
    public static int indexOfTheMaxElement(int[] array) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    // task 2
    public static double averageOfElements(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    // task 3
    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}
