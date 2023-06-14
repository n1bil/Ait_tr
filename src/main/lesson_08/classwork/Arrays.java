package main.lesson_08.classwork;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr[2]);
        arr[2] = 42;
        System.out.println(arr[2]);
        arr[1] = arr[2] * 2;
        System.out.println(arr[1]);
        System.out.println(arr.length);
        int[] odds = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println(odds.length);
        System.out.println(odds[3]);
        odds[2] = -1;
        System.out.println(odds[2]);
        int i = 4;
        System.out.println(odds[i]);
        i++;
        System.out.println(odds[i]);
        System.out.println("-----------------");
        printArray(odds);
        printArray(arr);
        System.out.println("Sum = " + sumArray(arr));
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("-----------------");

    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
