package main.lesson_54_MapAdv.classwork.words.utils;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean isAnagram(String word, String part) {
        if (word == null || part == null || part.isEmpty() || part.length() > word.length()) {
            return false;
        }
        word = word.toLowerCase();
        part = word.toLowerCase();
        Map<Character, Integer> lettersOfWord = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            lettersOfWord.merge(word.charAt(i), 1, Integer::sum);
        }
        Map<Character, Integer> lettersOfPart = new HashMap<>();
        for (int i = 0; i < part.length(); i++) {
            lettersOfPart.merge(part.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < part.length(); i++) {
            if (lettersOfPart.get(part.charAt(i)) > lettersOfWord.getOrDefault(part.charAt(i), 0)) { // если приходит null то верни 0
                return false;
            }
        }

        return true;
    }
}
