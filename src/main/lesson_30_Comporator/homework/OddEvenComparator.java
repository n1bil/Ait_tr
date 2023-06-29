package main.lesson_30_Comporator.homework;

import java.util.Comparator;

public class OddEvenComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        boolean number1 = o1 % 2 == 0;
        boolean number2 = o2 % 2 == 0;

        if (number1 && !number2) {
            return -1;
        } else if (!number1 && number2) {
            return 1;
        } else if (number1 && number2) {
            return o1.compareTo(o2);
        } else {
            return o2.compareTo(o1);
        }
    }
}
