package main.lesson_54_MapAdv.classwork;

import java.util.*;

public class WordsFreqAppl {
    public static void main(String[] args) {
        String[] words = {"abc", "ab", "limn", "limn", "ab", "limn", "a"};
        printWordsFrequency(words);
    }

    private static void printWordsFrequency(String[] words) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
//            if (result.containsKey(word)) {
//                result.put(word, result.get(word) + 1);
//            } else {
//                result.put(word, 1);
//            }
//            if (result.putIfAbsent(word, 1) != null) {      // положить если 1 если null или пусто
//                result.put(word, result.get(word) + 1);     // если не пусто то положить +1
//            }

//            result.computeIfPresent(word, (k, v) -> v + 1);
//            result.computeIfAbsent(word, k -> 1);

            result.merge(word, 1, (v1, v2) -> v1 + v2);     // если ничего нет то ставим 1 и остальной код ингорируем,
        }                                                         // если есть то выполняем суммирование
        System.out.println("====== Unsorted ======");
        Set<Map.Entry<String, Integer>> entries = result.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("====== Sorted by value desc ======");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        list.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        list.forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
