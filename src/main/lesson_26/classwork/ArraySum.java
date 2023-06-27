package main.lesson_26.classwork;

public class ArraySum {
    public static void main(String[] args) {
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (-10 - 10 + 1) + 10);
        }
//        printArray(array);
//        int sum = sumElOddInd(array);
//        System.out.println("Sum of elements with odd indexes = " + sum);
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println();
    }

    public int sumElOddInd(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                sum += array[i];
            }
        }
        return sum;
    }
}
