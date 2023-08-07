package main.lesson_57_Collectors.classwork.primitives;

import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.Stream;

public class StreamPrimitivesAppl {
    private static final int N_NUMBERS = 10;
    private static final int MIN = 1;
    private static final int MAX = 10;

    public static void main(String[] args) {
        Stream<Integer> numbers = getRandomNumbers(N_NUMBERS, MIN, MAX);
        numbers.forEach(System.out::println);
        System.out.println("==========================");
        int sum = getRandomNumbers(N_NUMBERS, MIN, MAX)
                .mapToInt(Integer::intValue)
                .peek(System.out::println)
                .sum();
        System.out.println("sum = " + sum);
        System.out.println("==========================");
        IntSummaryStatistics summaryStatistics =
                getRandomNumbers(N_NUMBERS, MIN, MAX)
                        .mapToInt(Integer::intValue)
                        .peek(System.out::println)
                        .summaryStatistics();
        System.out.println("Min = " + summaryStatistics.getMin());
        System.out.println("Max = " + summaryStatistics.getMax());
        System.out.println("Sum = " + summaryStatistics.getSum());
        System.out.println("Average = " + summaryStatistics.getAverage());
        System.out.println("====== Lotto 6 from 49 ======");
        new Random()
                .ints(1, 50)
                .distinct()
                .limit(6)
                .forEach(System.out::println);
        System.out.println("====== Shuffle ======");
        int[] array = {10, 20, 30, 40, 50};
        new Random()
                .ints(0, array.length)
                .distinct()
                .limit(array.length)
                .forEach(i -> System.out.println(array[i]));
    }

    private static Stream<Integer> getRandomNumbers(int nNumbers, int min, int max) {
        return new Random()
                .ints(min, max)
                .limit(nNumbers)
//                .mapToObj(n -> (Integer) n);      // analogue
                .boxed();
    }
}
