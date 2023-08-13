package main.lesson_61.homework;

import java.util.HashMap;
import java.util.Map;

public class WorkCount {
    public static void main(String[] args) {
        String sentence = "В 1800-х годах, в те времена, когда не было еще ни железных, ни шоссейных дорог, ни газового, ни стеаринового света, ни пружинных низких диванов, ни мебели без лаку, ни разочарованных юношей со стеклышками, ни либеральных философов-женщин, ни милых дам-камелий, которых так много развелось в наше время, – в те наивные времена, когда из Москвы, выезжая в Петербург в повозке или карете, брали с собой целую кухню домашнего приготовления, ехали восемь суток по мягкой, пыльной или грязной дороге и верили в пожарские котлеты, в валдайские колокольчики и бублики, – когда в длинные осенние вечера нагорали сальные свечи, освещая семейные кружки из двадцати и тридцати человек, на балах в канделябры вставлялись восковые и спермацетовые свечи, когда мебель ставили симметрично, когда наши отцы были еще молоды не одним отсутствием морщин и седых волос, а стрелялись за женщин и из другого угла комнаты бросались поднимать нечаянно и не нечаянно уроненные платочки, наши матери носили коротенькие талии и огромные рукава и решали семейные дела выниманием билетиков, когда прелестные дамы-камелии прятались от дневного света, – в наивные времена масонских лож, мартинистов, тугендбунда, во времена Милорадовичей, Давыдовых, Пушкиных, – в губернском городе К. был съезд помещиков, и кончались дворянские выборы.";

        System.out.println("Number of words in the sentence = " + countWords(sentence));

        Map<String, Integer> wordFrequencyMap = getWordFrequency(sentence);

        for (Map.Entry<String, Integer> map : wordFrequencyMap.entrySet()) {
            System.out.println(map.getKey() + ": " + map.getValue());
        }

    }

    public static int countWords(String sentence) {
        String[] words = sentence.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (word.endsWith(",") || word.endsWith(".") || word.endsWith("–")) {
                word = word.substring(0, word.length() - 1);
            }
            if (!word.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public static Map<String, Integer> getWordFrequency(String sentence) {
        String[] words = sentence.split("\\s+");
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            if (word.endsWith(",") || word.endsWith(".") || word.endsWith("–")) {
                word = word.substring(0, word.length() - 1);
            }
            if (!word.isEmpty()) {
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequencyMap;
    }
}
