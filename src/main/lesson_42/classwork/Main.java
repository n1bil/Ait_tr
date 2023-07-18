package main.lesson_42.classwork;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Marsel");
        words.add("Hello!");
        words.add("Bye");
        words.add("Marsel");
        System.out.println(words);
        System.out.println(words.size());

        System.out.println(words.contains("Hello!"));
        System.out.println(words.contains("Java"));
        words.remove("Hello!");
        System.out.println(words);
        words.add(1, "Java");
        System.out.println(words);
        System.out.println(words.get(1));
        System.out.println(words.indexOf("Marsel"));
        System.out.println(words.lastIndexOf("Marsel"));
        System.out.println(words.indexOf("JavaScript"));

        words.remove(2);
        System.out.println(words);

        words.set(1, "Marsel");
        System.out.println(words);


        System.out.println(words.isEmpty());
        words.clear();
        System.out.println(words.size());
        System.out.println(words.isEmpty());
        System.out.println(words);


    }
}













