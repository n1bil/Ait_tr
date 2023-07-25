package main.lesson_48.classwork.list;

import java.util.*;


public class ListPerformanceTest {
    public static final int N_NUMBERS = 100_000;
    public static final int MIN = 10;
    public static final int MAX = 100;
    private static Random random = new Random();

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        fillList(list);

        System.out.println("========== for-each =========");
        long t1 = System.currentTimeMillis();
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Sum = " + sum);
        System.out.println("duration = " + (t2 - t1) + " ms");

        System.out.println("========== iterator =========");
        t1 = System.currentTimeMillis();
        sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        t2 = System.currentTimeMillis();
        System.out.println("Sum = " + sum);
        System.out.println("duration = " + (t2 - t1) + " ms");

        System.out.println("========== for loop =========");
        t1 = System.currentTimeMillis();
        sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("Sum = " + sum);
        System.out.println("duration = " + (t2 - t1) + " ms");

    }

    private static void fillList(List<Integer> list) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < N_NUMBERS; i++) {
            list.add(MIN + random.nextInt(MAX - MIN));
        }
        long t2 = System.currentTimeMillis();
        System.out.println("duration of fillList = " + (t2 - t1) + " ms");
    }
}
