package main.lesson_26.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    Task1 task;

    @BeforeEach
    void setUp() {
        task = new Task1();
    }

    @Test
    void checkLength() {
        int[] array = new int[10];
        assertEquals(array.length, task.randomValues().length, "Array must be 10 length");
    }

    @Test
    void testRandomValues() {
        int[] array = task.randomValues();
        for (int i = 0; i < array.length; i++) {
            assertTrue(array[i] >= -10 && array[i] <= 10, "Generated value is outside the range of -10 to 10");
        }
    }

    @Test
    void checkDuplicate() {
        int[] array = {-2, -4, 3, 8, -5, -2, -4, 7, 2, 8};
        assertTrue(task.checkDuplicate(array), "Array must be true");
    }

}