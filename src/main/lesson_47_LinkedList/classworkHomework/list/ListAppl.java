package main.lesson_47_LinkedList.classworkHomework.list;

import main.lesson_47_LinkedList.classworkHomework.list.interfaces.IList;
import main.lesson_47_LinkedList.classworkHomework.list.model.MyLinkedList;

public class ListAppl {
    public static void main(String[] args) {
        IList<Integer> list = new MyLinkedList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(2);
        list.add(7);
        list.add(3);
        list.add(5);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(null);
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
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println("\n" + list.size());
        list.clear();
        System.out.println(list.size());

    }
}