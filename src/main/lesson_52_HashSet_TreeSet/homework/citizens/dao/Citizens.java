package main.lesson_52_HashSet_TreeSet.homework.citizens.dao;

import main.lesson_52_HashSet_TreeSet.homework.citizens.model.Person;

public interface Citizens {

    boolean add(Person person);

    boolean remove(int id);

    Person findById(int id);

    Iterable<Person> findAgeByRange(int minAge, int maxAge);

    Iterable<Person> findLastName(String lastname);

    Iterable<Person> getAllPersonsSortedById();

    Iterable<Person> getAllPersonsSortedByAge();

    Iterable<Person> getAllPersonsSortedByLastname();

    int size();
}
