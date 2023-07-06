package main.lesson_34_Enum_TwoDimensionArray.homework.matrix.utils;

public class Matrix {

    public static int sum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int[][] transp(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] transposeArray = new int[columns][rows];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                transposeArray[i][j] = matrix[j][i];
            }
        }
        return transposeArray;
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int[][] multiplication = new int[matrix1.length][matrix2[0].length];

        if (matrix1.length == matrix2[0].length) {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[i].length; j++) {
                    for (int k = 0; k < matrix2.length; k++) {
                        multiplication[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            return multiplication;
        }
        return null;
    }
}
