package main.lesson_49.classwork.citizens.dao;

import main.lesson_49.classwork.citizens.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CitizensImpl implements Citizens {

    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;
    private static Comparator<Person> lastnameComparator = (p1, p2) -> {
        int res = p1.getLastName().compareTo(p2.getLastName());
        return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };
    private static Comparator<Person> ageComparator = (p1, p2) -> {
        int res = Integer.compare(p1.getAge(), p2.getAge());
        return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };

    public CitizensImpl() {
        idList = new ArrayList<>();
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
    }

    public CitizensImpl(List<Person> citizens) {
        this(); // используем предыдущий конструктор
        for (Person person : citizens) {
            add(person);
        }
    }

    // 0(n)
    @Override
    public boolean add(Person person) {
        if (person == null) {                                   // если добавляем null-person
            return false;                                       // возвращаем сразу false
        }
        int index = Collections.binarySearch(idList, person);   // сохраняем индекс person в idList
        if (index >= 0) {                                       // если больше и равен нулю, значит person уже с таким индексом существует
            return false;                                       // и возращаем false
        }                                                       // если всё таки вернул отрицательное, значит такого person нет и идём дальше
        index = -index - 1;
        idList.add(index, person);
        index = Collections.binarySearch(ageList, person, ageComparator);
        index = index >= 0 ? index : -index - 1;
        ageList.add(index, person);
        index = Collections.binarySearch(lastNameList, person, lastnameComparator);
        index = index >= 0 ? index : -index - 1;
        lastNameList.add(index, person);

        return true;
    }

    // 0(n)
    @Override
    public boolean remove(int id) {
        Person victim = findById(id);
        if (victim == null) {
            return false;
        }
        idList.remove(victim);
        lastNameList.remove(victim);
        ageList.remove(victim);
        return true;
    }

    // 0(log(n))
    @Override
    public Person findById(int id) {
        Person pattern = new Person(id, null, null, null);
        int index = Collections.binarySearch(idList, pattern); //log

        return index < 0 ? null : idList.get(index);           //0(1)
    }

    // 0(log(n))
    @Override
    public Iterable<Person> findAgeByRange(int minAge, int maxAge) {
        LocalDate now = LocalDate.now();
        Person pattern1 = new Person(Integer.MIN_VALUE, null, null, now.minusYears(minAge));
        int from = -Collections.binarySearch(ageList, pattern1, ageComparator) - 1;
        Person pattern2 = new Person(Integer.MAX_VALUE, null, null, now.minusYears(maxAge));
        int to = -Collections.binarySearch(ageList, pattern2, ageComparator) - 1;

        return ageList.subList(from, to);
    }

    // 0(log(n))
    @Override
    public Iterable<Person> findLastName(String lastname) {
        Person pattern1 = new Person(Integer.MIN_VALUE, null, lastname, null);
        int from = -Collections.binarySearch(lastNameList, pattern1, lastnameComparator) - 1;    //log(n)
        Person pattern2 = new Person(Integer.MAX_VALUE, null, lastname, null);
        int to = -Collections.binarySearch(lastNameList, pattern2, lastnameComparator) - 1;      //log(n)

        return lastNameList.subList(from, to);  // 0(1)
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

    @Override
    public int size() {
        return idList.size();
    }
}
