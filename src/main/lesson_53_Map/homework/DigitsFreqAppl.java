package main.lesson_53_Map.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DigitsFreqAppl {

    static Random random = new Random();

    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            int randomNumber = random.nextInt(Integer.MAX_VALUE);
            String numberString = Integer.toString(randomNumber);
            numbers.add(numberString);
        }


        Map<Character, Integer> map = new HashMap<>();
        for (String strNumbers : numbers) {
            for (char digitChar : strNumbers.toCharArray()) {
                map.put(digitChar, map.getOrDefault(digitChar, 0) + 1);
            }
        }

        for (char digitChar : map.keySet()) {
            System.out.println("Digit: " + digitChar + ", Frequency: " + map.get(digitChar));
        }
    }
}