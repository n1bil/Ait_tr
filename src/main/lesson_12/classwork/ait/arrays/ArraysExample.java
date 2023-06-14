package main.lesson_12.classwork.ait.arrays;

import main.lesson_12.classwork.ait.arrays.utils.ArraysTools;

public class ArraysExample {
    public static void main(String[] args) {
        int[] arr = new int[10];
        ArraysTools.fillArray(arr, 10, 99);
        ArraysTools.printArray(arr);
//        ArraysTools.bubbling(arr);
        ArraysTools.bubbleSort2(arr);
        ArraysTools.printArray(arr);
        int index = ArraysTools.binarySearch(arr, 42);
        System.out.println("Index = " + index);
    }


}
