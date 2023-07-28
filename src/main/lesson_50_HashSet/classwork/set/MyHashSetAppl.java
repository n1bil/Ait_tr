package main.lesson_50_HashSet.classwork.set;

import main.lesson_50_HashSet.classwork.set.model.ISet;
import main.lesson_50_HashSet.classwork.set.model.MyHashSet;

import java.util.Collections;

public class MyHashSetAppl {
    public static void main(String[] args) {
        ISet<String> mySet = new MyHashSet<>();
        System.out.println(mySet.size());
        mySet.add("Boston");
        mySet.add("Atlanta");
        System.out.println(mySet.add("Chicago"));
        mySet.add("New York");
        mySet.add("Detroit");
        System.out.println(mySet.size());
        System.out.println(mySet.add("Chicago"));
        System.out.println(mySet.size());
        System.out.println(mySet.contains("Boston"));
        System.out.println(mySet.contains("Dallas"));
        System.out.println(mySet.remove("Boston"));
        System.out.println(mySet.size());
        System.out.println(mySet.remove("Miami"));
        System.out.println(mySet.size());
        System.out.println(mySet.contains("Boston"));
        System.out.println("====== Iterator ======");
        for (String str : mySet) {
            System.out.println(str);
        }
    }
}
