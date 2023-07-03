package main.lesson_32.homework.dateSort.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DateSortTest {

    Comparator<String> dataComparator;

    @BeforeEach
    void setUp() {
        dataComparator = (s1, s2) -> {
            String[] strings1 = s1.split("-");
            String[] strings2 = s2.split("-");

            for (int i = strings1.length - 1; i >= 0; i--) {
                int result = strings1[i].compareTo(strings2[i]);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        };
    }

    @Test
    void testDateSort() {
        String[] dates = {
                "07-05-1990",
                "28-01-2010",
                "11-08-1990",
                "15-01-2010",
                "16-06-1970"
        };
        Arrays.sort(dates, dataComparator);
        System.out.println(Arrays.toString(dates));
        String[] expected = {
                "16-06-1970",
                "07-05-1990",
                "11-08-1990",
                "15-01-2010",
                "28-01-2010"
        };
        assertArrayEquals(expected, dates);
    }
}
