package main.lesson_42.classwork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Marsel");
        words.add("Sidikov");
        words.add("29");
        words.add("1.85");

        HashSet<String> names = new HashSet<>(); // нет индексов
        names.add("Marsel");
        names.add("Lena");
        names.add("Igor");
        names.add("Marsel");

//        System.out.println(names.get(0)); // нет метода get

//        for (int i = 0; i < words.size(); i++) {
//            System.out.println(words.get(i));
//        }
//
//        Iterator<String> listIterator = words.listIterator();
//
//        while (listIterator.hasNext()) {
//            System.out.println(listIterator.next());
//        }
//
//        Iterator<String> setIterator = names.iterator();
//        while (listIterator.hasNext()) {
//            System.out.println(setIterator.next());
//        }
//
        for (String word : words) {
            System.out.println(word);
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
