package main.lesson_11.classwork;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};     // Создаем массив целых чисел
        System.out.print("Исходный массив:   ");
        // напечатали массив
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();
        reverseArray(numbers); // Используем метод reverseArray для разворота массива

        System.out.print("Развёрнутый массив: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
    }

    public static void reverseArray(int[] array) {
        if (array == null || array.length <= 1) {
            System.out.println();
            return;
        }
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}
