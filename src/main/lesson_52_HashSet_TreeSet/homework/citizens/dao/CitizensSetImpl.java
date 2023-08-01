package main.lesson_52_HashSet_TreeSet.homework.citizens.dao;

import main.lesson_52_HashSet_TreeSet.homework.citizens.model.Person;

import java.time.LocalDate;
import java.util.*;

public class CitizensSetImpl implements Citizens {

    private TreeSet<Person> idList;
    private TreeSet<Person> lastNameList;
    private TreeSet<Person> ageList;
    private static Comparator<Person> lastnameComparator = (p1, p2) -> {
        int res = p1.getLastName().compareTo(p2.getLastName());
        return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };
    private static Comparator<Person> ageComparator = (p1, p2) -> {
        int res = Integer.compare(p1.getAge(), p2.getAge());
        return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };

    public CitizensSetImpl() {
        idList = new TreeSet<>();
        lastNameList = new TreeSet<>(lastnameComparator);
        ageList = new TreeSet<>(ageComparator);
    }

    public CitizensSetImpl(List<Person> citizens) {
        this(); // используем предыдущий конструктор
        for (Person person : citizens) {
            add(person);
        }
    }

    // 0(log n)
    @Override
    public boolean add(Person person) {

        return person != null && idList.add(person) && lastNameList.add(person) && ageList.add(person);
    }

    // 0(log n)
    @Override
    public boolean remove(int id) {
        Person victim = findById(id);

        return victim != null && idList.remove(victim) && lastNameList.remove(victim) && ageList.remove(victim);
    }

    // 0(log n)
    @Override
    public Person findById(int id) {
        Person pattern = new Person(id, null, null, null);
        if (idList.contains(pattern)) {
            return idList.ceiling(pattern);
        }
        return null;
    }

    // 0(log n)
    @Override
    public Iterable<Person> findAgeByRange(int minAge, int maxAge) {

        LocalDate now = LocalDate.now();
        Person pattern1 = new Person(Integer.MIN_VALUE, null, null, now.minusYears(minAge));
        Person pattern2 = new Person(Integer.MAX_VALUE, null, null, now.minusYears(maxAge));

        return ageList.subSet(pattern1, true, pattern2, true);
    }

    // 0(log n)
    @Override
    public Iterable<Person> findLastName(String lastname) {
        Person pattern1 = new Person(Integer.MIN_VALUE, null, lastname, null);
        Person pattern2 = new Person(Integer.MAX_VALUE, null, lastname, null);

        return lastNameList.subSet(pattern1, pattern2);
    }

    // 0(1)
    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return idList;
    }

    // 0(1)
    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return ageList;
    }

    // 0(1)
    @Override
    public Iterable<Person> getAllPersonsSortedByLastname() {
        return lastNameList;
    }

    // 0(1)
    @Override
    public int size() {
        return idList.size();
    }
}