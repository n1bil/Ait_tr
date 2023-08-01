package main.lesson_52_HashSet_TreeSet.classwork.set;

import java.util.*;

public class SetAppl {
    public static void main(String[] args) {
        List<String> list = List.of("c", "ad", "abc", "b", "ab", "bd", "b");
        System.out.println("\tPrint List");
        list.forEach(System.out::println);
        Set<String> hashset = new HashSet<>(3, 10);
        hashset.addAll(list);
        System.out.println("\tPrint HashSet");
        hashset.forEach(System.out::println);
        List<String> uniqueList = new ArrayList<>(new HashSet<>(list));
        System.out.println("\tPrint Unique List");
        uniqueList.forEach(System.out::println);
        TreeSet<String> treeSet = new TreeSet<>(list);
        System.out.println("\nPrint TreeSet");
        treeSet.forEach(System.out::println);
        System.out.println("\nPrint TreeSet return one element");
//        System.out.println(treeSet.first());
//        System.out.println(treeSet.last());
        System.out.println(treeSet.ceiling("abd"));
//        System.out.println(treeSet.ceiling("ca"));
//        System.out.println(treeSet.floor("aba"));
//        System.out.println("\nPrint TreeSet return multiply element");
//        treeSet.headSet("bd").forEach(System.out::println);
//        treeSet.headSet("bd", true).forEach(System.out::println); // включительно
//        treeSet.tailSet("abc", false).forEach(System.out::println);
//        treeSet.subSet("abc", "c").forEach(System.out::println);
//        treeSet.subSet("abc", false, "c", true).forEach(System.out::println);
//        System.out.println("\tPrint TreeSet comparator");
//        TreeSet<String> setComparator = new TreeSet<>((o1, o2) -> {
//            int res = Integer.compare(o1.length(), o2.length());
//            return res != 0 ? res : o1.compareTo(o2);
//        });
//        setComparator.addAll(list);
//        setComparator.forEach(System.out::println);
    }
}
