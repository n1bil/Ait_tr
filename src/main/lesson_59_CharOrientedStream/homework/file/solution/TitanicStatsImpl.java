package main.lesson_59_CharOrientedStream.homework.file.solution;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TitanicStatsImpl implements TitanicStats {
    File file;
    String delimiter;

    public TitanicStatsImpl(String file, String delimiter) {
        this.file = new File(file);
        this.delimiter = delimiter;
    }

    public TitanicStatsImpl(File file, String delimiter) {
        this.file = file;
        this.delimiter = delimiter;
    }

    public double totalFares() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return getData(br)
                    .map(s -> s[10])
                    .mapToDouble(Double::parseDouble)
                    .sum();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Map<String, Double> avgFaresByClasses() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return getData(br)
                    .collect(Collectors.groupingBy(s -> s[2], Collectors.averagingDouble(value -> Double.parseDouble(value[10]))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public Map<String, Long> totalSurvived() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return getData(br)
                    .collect(Collectors.groupingBy(s -> s[1].equals("1") ? "Survived" : "Non survived", Collectors.counting()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public Map<String, Long> totalSurvivedByGender() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return getData(br)
                    .collect(Collectors.groupingBy(s -> survivedGender(s[5], s[1]), Collectors.counting()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public Map<String, Long> totalSurvivedChildren() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return getData(br)
                    .filter(s -> s[6] != null && !s[6].isEmpty())
                    .filter(s -> Double.parseDouble(s[6]) < 18)
                    .collect(Collectors.groupingBy(s -> s[1].equals("1") ? "Survived" : "Non survived", Collectors.counting()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }


    private String survivedGender(String gender, String survived) {
        survived = survived.equals("1") ? "survived" : "non survived";
        return gender + " " + survived;
    }

    private Stream<String[]> getData(BufferedReader br) {
        return br.lines().skip(1).map(s -> s.split(delimiter));
    }

}
