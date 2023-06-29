package main.lesson_29_Predicate.classwork.generic;

import main.lesson_29_Predicate.classwork.generic.utils.JsonWrapper2;

public class JsonWrapper2Appl {
    public static void main(String[] args) {
        JsonWrapper2<Long> wrapper2 = new JsonWrapper2<>(10L);
        System.out.println(wrapper2);
        Long a = wrapper2.getValue();
        System.out.println(a);
    }
}
