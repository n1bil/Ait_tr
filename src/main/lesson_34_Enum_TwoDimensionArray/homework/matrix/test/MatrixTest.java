package main.lesson_34_Enum_TwoDimensionArray.homework.matrix.test;

import main.lesson_34_Enum_TwoDimensionArray.homework.matrix.utils.Matrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {
    int[][] matrix1 = {{1, 2, 3}};     // [1][3] // одна строка, три столбца
    int[][] matrix2 = {{1}, {2}, {3}}; // [3][1] // три столбца, одна строка

    @Test
    void testSum() {
        assertEquals(6, Matrix.sum(matrix1));
        assertEquals(6, Matrix.sum(matrix2));
    }

    @Test
    void testTransp() {
        assertArrayEquals(matrix2, Matrix.transp(matrix1));
    }

    @Test
    void testMultiply() {
        int[][] expected1 = {{14}};
        assertArrayEquals(expected1, Matrix.multiply(matrix1, matrix2));
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr2 = {{1, 2}, {3,4},{5, 6}};
        int[][] expected2 = {{22, 28}, {49, 64}};
        assertArrayEquals(expected2, Matrix.multiply(arr1, arr2));
    }

}
