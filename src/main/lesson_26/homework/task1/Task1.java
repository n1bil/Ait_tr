package main.lesson_26.homework.task1;

import java.util.Random;

public class Task1 {

    public int[] randomValues() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(21) - 10;
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;
    }

    public boolean checkDuplicate(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
