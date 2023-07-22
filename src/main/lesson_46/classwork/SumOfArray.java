package main.lesson_46.classwork;

public class SumOfArray {
    public static void main(String[] args) {
        int[] arr = new int[100];

        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " | ");
            sum1 += arr[i];
        }
        System.out.println();
        System.out.println("sum loop = " + sum1);
        int l = arr.length;
        System.out.println("Amount of elements: " + l);

        int sum2 = (arr[0] + arr[arr.length - 1]) * (l / 2);
        System.out.println("Sum of Eller: " + sum2);
    }
}
