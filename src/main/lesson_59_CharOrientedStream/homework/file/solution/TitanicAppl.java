package main.lesson_59_CharOrientedStream.homework.file.solution;

import java.util.Map;

public class TitanicAppl {
    public static void main(String[] args) {
        TitanicStats stats = new TitanicStatsImpl("src/main/lesson_59_CharOrientedStream/homework/file/train.csv", ",");
        System.out.println("Total fares: " + stats.totalFares());
        Map<String, Double> avgFares = stats.avgFaresByClasses();
        avgFares.forEach(((s, aDouble) -> System.out.println("Class " + s + " average fares is: " + aDouble)));
        Map<String, Long> survived = stats.totalSurvived();
        survived.forEach(((s, aLong) -> System.out.println("Total " + s + " = " + aLong)));
        survived = stats.totalSurvivedByGender();
        survived.forEach(((s, aLong) -> System.out.println(s + " = " + aLong)));
        survived = stats.totalSurvivedChildren();
        survived.forEach(((s, aLong) -> System.out.println("Children " + s + " = " + aLong)));
    }
}
