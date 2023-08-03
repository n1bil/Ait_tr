package main.lesson_55_FunctionalProgramming.classwork.fp;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 9, 2, 8, 3, 7, 4, 6, 5));
        // list.sort((x, y) -> Integer.compare(x, y));
        list.sort(Integer::compare);
//        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);
    }
}
