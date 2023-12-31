package main.lesson_41.homework.task2;

import main.lesson_41.homework.task2.interfaces.IList;
import main.lesson_41.homework.task2.model.MyArrayList;

import java.util.Collections;
import java.util.Comparator;

public class ListAppl {
    public static void main(String[] args) {
        IList<Integer> list = new MyArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(2);
        list.add(7);
        list.add(3);
        list.add(5);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(10);
        list.add(7);
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        System.out.println(list.get(4));

        System.out.println(list.indexOf(3));
        System.out.println(list.indexOf(7));
        System.out.println(list.contains(5));
        System.out.println(list.contains(-5));
        System.out.println(list.indexOf(null));
        System.out.println("====== Test Homework ======");
        System.out.println(list.lastIndexOf(7));
        list.remove(5);
        list.set(1, 17);
        System.out.println(list.get(1));
        list.add(2, 11111);
        Comparator<Integer> comparator = Integer::compareTo;
        list.sort(comparator);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());

    }


}