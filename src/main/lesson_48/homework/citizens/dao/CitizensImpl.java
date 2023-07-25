package main.lesson_48.homework.citizens.dao;

import main.lesson_48.homework.citizens.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CitizensImpl implements Citizens {

    private List<Person> citizens;
    int size;

    public CitizensImpl() {
        citizens = new ArrayList<>();
    }

    public CitizensImpl(List<Person> citizens) {
        this.citizens = citizens;
    }

    @Override
    public boolean add(Person person) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Person find(int id) {
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        return null;
    }

    @Override
    public Iterable<Person> lastName(String lastname) {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByLastname() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
