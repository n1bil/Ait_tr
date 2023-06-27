package main.lesson_26.classwork;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySumTest {

    ArraySum arraySum;

    @BeforeEach
    void setUp() {
        arraySum = new ArraySum();
    }

    @Test
    void testSumElOddInd() {
        int[] array = {10, 20, -30, 40};
        // тестовые данные
        arraySum.sumElOddInd(array);
        assertEquals(60, arraySum.sumElOddInd(array));
    }

}