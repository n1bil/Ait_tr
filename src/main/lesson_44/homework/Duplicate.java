package main.lesson_44.homework;

import java.util.*;

public class Duplicate {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            integers.add(i);
        }

        int randomNumber = new Random().nextInt(100) + 1;
        int randomPlace = new Random().nextInt(integers.size() + 1);

        integers.add(randomPlace, randomNumber);

        int index = findDuplicate(integers);
        System.out.println("Number " + index + " is a duplicate");
    }

    private static int findDuplicate(ArrayList<Integer> integers) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : integers) {
            if (!set.add(integer)) {
                return integer;
            }
        }
        return -1;
    }
}
