package main.lesson_59_CharOrientedStream.homework.file.solution;

import java.util.Map;

public interface TitanicStats {

    double totalFares();

    Map<String, Double> avgFaresByClasses();

    Map<String, Long> totalSurvived();

    Map<String, Long> totalSurvivedByGender();

    Map<String, Long> totalSurvivedChildren();
}
