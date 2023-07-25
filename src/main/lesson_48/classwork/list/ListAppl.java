package main.lesson_48.classwork.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListAppl {

    private static final int N_NUMBERS = 10;
    private static final int MIN = 10;
    private static final int MAX = 20;
    private static Random random = new Random();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        fillList(list);
        printList(list);
        //NB! Wrong
//        for (Integer integer : list) {
//            if (integer == 15) {
//                list.remove(integer);
//            }
//        }
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            if (integer >= 15) {
//                iterator.remove();
//            }
//        }

        list.removeIf(integer -> integer == 15);

        printList(list);
    }

    private static void printList(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
        System.out.println();
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < N_NUMBERS; i++) {
            list.add(MIN + random.nextInt(MAX - MIN));
        }
    }
}
