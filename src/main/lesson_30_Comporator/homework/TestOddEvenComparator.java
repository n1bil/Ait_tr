package main.lesson_30_Comporator.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestOddEvenComparator {

    Integer[] origin;

    @BeforeEach
    void setUp() {
        origin = new Integer[]{1, 4, 3, 2, 5, 6, 9, 8, 7, 3};
    }

    @Test
    void testOddEvenComparator() {
        Integer[] expected = {2, 4, 6, 8, 9, 7, 5, 3, 3, 1};
        Arrays.sort(origin, new OddEvenComparator());
        assertArrayEquals(expected, origin);

    }
}
