package main.lesson_57_Collectors.classwork.programmer;

import main.lesson_57_Collectors.classwork.programmer.model.Programmer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProgrammerAppl {
    public static void main(String[] args) {
        List<Programmer> programmers = getProgrammers();
        System.out.println("====== Most Skilled Programmes ======");
        printMostSkilledProgrammers(programmers);

        System.out.println("====== Most Popular Technologies ======");
        printPopularTechnologies(programmers);


    }

    private static void printPopularTechnologies(List<Programmer> programmers) {
        System.out.println("====== Show all technologies ======");
        Iterable<String> technologies = programmers.stream()
                .map(programmer -> programmer.getTechnologies())
                .flatMap(strings -> Arrays.stream(strings))
//                .collect(Collectors.toSet())
                .collect(Collectors.toList());
        StreamSupport.stream(technologies.spliterator(), false)
                .distinct()                                             // remove duplicates
                .forEach(System.out::println);

        System.out.println("====== Grouping By ======");
        Map<Object, Long> techFrequency = programmers.stream()
                .map(Programmer::getTechnologies)
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
//        System.out.println(techFrequency);
        Long maxTech = techFrequency.values().stream()
                .max(Long::compare)
                .orElse(null);
        if (maxTech != null) {
            techFrequency.entrySet().stream()
                    .filter(objectLongEntry -> maxTech.equals(objectLongEntry.getValue()))
                    .forEach(System.out::println);
        }
    }

    private static void printMostSkilledProgrammers(List<Programmer> programmers) {
        Map<Integer, List<Programmer>> skilledProgrammers = programmers.stream()
                .collect(Collectors.groupingBy(programmer -> programmer.getTechnologies().length));
        Integer max = skilledProgrammers.keySet().stream()
                .max(Integer::compare)
                .orElse(null);
//        Map<Integer, List<Programmer>> skilledProgrammers = new HashMap<>();
//        int max = 0;
//        for (Programmer programmer : programmers) {
//            int size = programmer.getTechnologies().length;                 // получаем размер технологии программиста
//            max = Math.max(size, max);
//            skilledProgrammers.putIfAbsent(size, new ArrayList<>());        // положить если такой отсутствует размер технологий и пустой список
//            skilledProgrammers.get(size).add(programmer);                   // добавить программиста по полученому размеру
//        }
        skilledProgrammers.get(max).forEach(System.out::println);


//        Programmer mostSkilled = null;
//        int maxTechnologies = 0;
//
//        for (Programmer programmer : programmers) {
//            if (programmer.getTechnologies().length > maxTechnologies) {
//                mostSkilled = programmer;
//                maxTechnologies = programmer.getTechnologies().length;
//            }
//        }
//        System.out.println(mostSkilled);
    }

    private static List<Programmer> getProgrammers() {
        return List.of(
                new Programmer("Peter", "C++", "Python", "Java", "Kotlin"),
                new Programmer("John", "Python", "Java"),
                new Programmer("Helen", "Kotlin", "Scala", "Java", "Javascript"),
                new Programmer("Jacob", "Python", "Go"),
                new Programmer("Petrovich", "Fortran", "Algol", "PL-1")
        );
    }
}
