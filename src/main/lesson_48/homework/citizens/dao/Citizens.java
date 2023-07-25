package main.lesson_48.homework.citizens.dao;

import main.lesson_48.homework.citizens.model.Person;

public interface Citizens {

    boolean add(Person person);

    boolean remove(int id);

    Person find(int id);

    Iterable<Person> find(int minAge, int maxAge);

    Iterable<Person> lastName(String lastname);

    Iterable<Person> getAllPersonsSortedById();

    Iterable<Person> getAllPersonsSortedByAge();

    Iterable<Person> getAllPersonsSortedByLastname();

    int size();
}
