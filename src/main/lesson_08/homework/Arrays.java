package main.lesson_08.homework;

public class Arrays {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 6, 5, 10, 2, 9};
        reverseArray(array);
        System.out.println("Array sum: " + sumOddsElements(array));
        System.out.println("Array product: " + multiplyEvenElements(array));

    }

    // task 1
    public static void reverseArray(int[] array) {
        System.out.print("Reverse array: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // task 2
    public static int sumOddsElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                sum += array[i];
            }
        }
        return sum;
    }

    // task 3
    public static int multiplyEvenElements(int[] array) {
        int sum = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sum *= array[i];
            }
        }
        return sum;
    }
}












