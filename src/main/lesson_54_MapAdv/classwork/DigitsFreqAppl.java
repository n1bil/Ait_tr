package main.lesson_54_MapAdv.classwork;

import java.util.*;

public class DigitsFreqAppl {

    static Random random = new Random();

    public static void main(String[] args) {
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < 1_000_000; i++) {
            int number = random.nextInt(Integer.MAX_VALUE);
            String[] digits = Integer.toString(number).split("");
            for (String string : digits) {
                if (res.containsKey(string)) {
                    res.put(string, res.get(string) + 1);
                } else {
                    res.put(string, 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(res.entrySet());
        list.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        list.forEach(System.out::println);
    }
}