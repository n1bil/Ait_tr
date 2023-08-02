package main.lesson_53_Map.classwork.map;

import java.util.*;

public class WordsFreqAppl {
    public static void main(String[] args) {
        String[] words = {"abc", "ab", "limn", "limn", "ab", "limn", "a"};
        printWordsFrequency(words);
    }

    private static void printWordsFrequency(String[] words) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        System.out.println("====== Unsorted ======");
        Set<Map.Entry<String, Integer>> entries = result.entrySet();
        for (Map.Entry<String, Integer> entry: entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("====== Sorted by value desc ======");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        list.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        list.forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
