package main.lesson_09.homework;

import java.util.Arrays;
import java.util.Random;

public class ArrayHomework {
    public static void main(String[] args) {

        int[] array = {56, 73, 15, -10, 37, -14, 25, 65, 33, 38};
//        maxElementOfIndex(array);

        reverseArray();

//        chessBoard();
    }

    // task 1
    public static void maxElementOfIndex(int[] array) {
        int maxNumber = 0;
        int indexMaxNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
                indexMaxNumber = i;
            }
        }
        System.out.println("Max element of the array: " + maxNumber);
        System.out.println("Index of the array: " + indexMaxNumber);
    }

    // task 2
    public static void reverseArray() {
        int[] numbers = generateRandomValues();
        int[] reverseArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            reverseArray[numbers.length - 1 - i] = numbers[i];
        }
        System.out.println(Arrays.toString(reverseArray));
    }

    private static int[] generateRandomValues() {
        int[] numbers = new int[20];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(20 - 10 + 1) + 10;
        }

        System.out.println(Arrays.toString(numbers));
        return numbers;
    }

    // task 3
    public static void chessBoard() {
        int[][] board = new int[8][8];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if ((row + col) % 2 == 0) {
                    board[row][col] = 0;
                } else {
                    board[row][col] = 1;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}











