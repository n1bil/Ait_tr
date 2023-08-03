package main.lesson_55_FunctionalProgramming.classwork.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAppl {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 9, 2, 8, 3, 7, 4, 6, 5));
        list.stream()
                .filter(x -> x > 3)             // output greater than 3
                .peek(x -> System.out.println("peek before sorted: " + x))
                .sorted()
                .forEach(System.out::println);
        System.out.println("=============");
        list.forEach(System.out::println);      // сам list остался неотсортированным
        System.out.println("=============");
        Integer[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        Stream<Integer> stream = Arrays.stream(arr)
                .filter(x -> x > 2)
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("peek: " + x))
                .sorted((x, y) -> Integer.compare(y, x));
        stream.forEach(System.out::println);
        System.out.println("==============");
//        stream.forEach(System.out::println);    // вто раз вызывать не можем
        int sum = Arrays.stream(arr)
                .map(integer -> integer * 10)
                .reduce(0, Integer::sum);
        System.out.println("Sum = " + sum);

        int mul = Arrays.stream(arr)
                .reduce(1, (accum, x) -> accum * x);
        System.out.println("Multiply = " + mul);
        String line = Arrays.stream(arr)
                .sorted()
                .map(x -> x.toString())
                .reduce("Result = ", (a, b) -> a + b);
        System.out.println(line);
        Integer[] sortedNum = Arrays.stream(arr)
                .sorted()
//                .toArray(value -> new Integer[value]);
                .toArray(Integer[]::new);                   // собрали массив arr в новый массив
        System.out.println("===== print array =====");
        Arrays.stream(sortedNum).forEach(System.out::println);
        System.out.println("============");
        Integer first = Arrays.stream(arr)
                .peek(x -> System.out.println("x = " + x))
                .filter(integer -> integer > 3)
                .filter(integer -> integer % 2 == 0)
                .findFirst()
                .orElse(null);
        System.out.println(first);

    }
}
