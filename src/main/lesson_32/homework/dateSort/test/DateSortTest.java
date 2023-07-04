package main.lesson_32.homework.dateSort.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DateSortTest {

    Comparator<String> dataComparator;

    @BeforeEach
    void setUp() {                                                  // пример сравнений:
        dataComparator = (s1, s2) -> {                              // strings1[0] и strings2[0] - год
            String[] strings1 = s1.split("-");                // strings1[1] и strings2[1] - месяц
            String[] strings2 = s2.split("-");                // strings1[2] и strings2[2] - день

            for (int i = strings1.length - 1; i >= 0; i--) {        // начинаем сравнивать с конца, то есть с года
                int result = strings1[i].compareTo(strings2[i]);    // если год одинаково, то потом месяц и потом день если тоже одинаково
                if (result != 0) {                                  // если не равных
                    return result;                                  // то вернуть результат
                }
            }
            return 0;                                               // если всё одинаково
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
