package main.lesson_29_Predicate.classwork.generic;

import main.lesson_29_Predicate.classwork.generic.utils.JsonWrapper1;

public class JsonWrapper1Appl {
    public static void main(String[] args) {
        JsonWrapper1 wrapper1 = new JsonWrapper1("10");
        System.out.println(wrapper1);
        String a = (String) wrapper1.getValue();
        System.out.println(a);
    }
}
