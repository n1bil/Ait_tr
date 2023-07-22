package main.lesson_45.classwork.Consultation;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NumberProcessor processor = new NumberProcessor();
        List<Integer> numbers = Arrays.asList(178, 21, 15, 16, 77, 13);



        List<Integer> result = processor.filter(numbers, integer -> integer % 2 == 0);
        System.out.println(result);
    }
}
