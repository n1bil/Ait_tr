package main.lesson_57_Collectors.homework;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PomegranateAppl {

    private static AtomicInteger boxCounter = new AtomicInteger(1);

    public static void main(String[] args) {
        List<Box> boxes = generateRandomQuantityOfBoxes();

        // task 2
        int totalSeeds = boxes.stream()
                .map(Box::getGranates)
                .flatMap(Collection::stream)
                .mapToInt(value -> value.seeds.size())
                .sum();
        System.out.println(totalSeeds);

        // task 3
        int maxSeedsInTheFirstBox = boxes.stream()
                .map(box -> box.getGranates().get(0))
                .map(Pomegranate::getSeeds)
                .mapToInt(List::size)
                .max()
                .orElse(0);
        System.out.println(maxSeedsInTheFirstBox);

        // task 4
        List<String> namesOfBoxesWithMaxSeeds = boxes.stream()
                .filter(box -> box.getGranates().stream()
                        .anyMatch(pomegranate -> pomegranate.getSeeds().size() == 700))
                .map(Box::getName)
                .collect(Collectors.toList());

        namesOfBoxesWithMaxSeeds.forEach(System.out::println);


    }


    private static List<Box> generateRandomQuantityOfBoxes() {
        int randomQuantity = new Random().nextInt(200 - 100 + 1) + 100;

        return Stream.generate(() -> new Box("Box" + boxCounter.getAndIncrement(), generateRandomQuantityOfPomegranates()))
                .limit(randomQuantity)
                .collect(Collectors.toList());
    }

    private static List<Pomegranate> generateRandomQuantityOfPomegranates() {
        int randomQuantity = new Random().nextInt(20 - 10 + 1) + 10;

        return Stream.generate(() -> new Pomegranate(generateRandomQuantityOfSeeds()))
                .limit(randomQuantity)
                .collect(Collectors.toList());
    }

    private static List<Seed> generateRandomQuantityOfSeeds() {
        int randomQuantity = new Random().nextInt(700 - 400 + 1) + 400;

        return Stream.generate(Seed::new)
                .limit(randomQuantity)
                .collect(Collectors.toList());
    }
}
