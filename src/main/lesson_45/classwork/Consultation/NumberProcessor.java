package main.lesson_45.classwork.Consultation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NumberProcessor {
    public List<Integer> filter(List<Integer> numbers, Predicate<Integer> integerPredicate) {
        List<Integer> filtered = new ArrayList<>();

        for (int number : numbers) {
            if (integerPredicate.test(number)) {
                filtered.add(number);
            }
        }

        return filtered;
    }
}
