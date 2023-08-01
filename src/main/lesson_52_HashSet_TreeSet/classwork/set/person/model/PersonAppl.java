package main.lesson_52_HashSet_TreeSet.classwork.set.person.model;

import java.util.HashSet;
import java.util.Set;

public class PersonAppl {
    public static void main(String[] args) {
        Person john = new Person(1, "John", "Smith");
        Person mary = new Person(2, "Mary", "Jackson");
        Set<Person> people = new HashSet<>();
        people.add(john);
        people.add(mary);
        System.out.println(people.contains(john));
        System.out.println(people.contains(mary));
        System.out.println("===========");
        mary.setLastName("Smith");
        System.out.println(people.contains(john));
        System.out.println(people.contains(mary));
        System.out.println(people.size());
        people.forEach(System.out::println);
    }
}
