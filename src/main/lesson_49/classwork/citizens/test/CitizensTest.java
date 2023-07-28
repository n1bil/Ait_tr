package main.lesson_49.classwork.citizens.test;

import main.lesson_49.classwork.citizens.dao.Citizens;
import main.lesson_49.classwork.citizens.dao.CitizensImpl;
import main.lesson_49.classwork.citizens.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensTest {

    private Citizens citizens;
    static final LocalDate now = LocalDate.now();

    @BeforeEach
    void setUp() {
        citizens = new CitizensImpl(List.of(
                new Person(1, "Peter", "Jackson", now.minusYears(23)),
                new Person(2, "John", "Smith", now.minusYears(20)),
                new Person(3, "Mary", "Jackson", now.minusYears(23)),
                new Person(4, "Rabindranath", "Tagor", now.minusYears(25))
        ));
    }

    @Test
    void testCitizensImplListOfPeople() {
        List<Person> personList = List.of(
                new Person(1, "Peter", "Anderson", now.minusYears(26)),
                new Person(1, "Frank", "Mikel", now.minusYears(24)),
                new Person(2, "Joshua", "Anderson", now.minusYears(26)),
                new Person(3, "Steve", "Anderson", now.minusYears(26)),
                new Person(4, "Hank", "Jackson", now.minusYears(27)),
                new Person(5, "Lui", "Johnson", now.minusYears(26)));
        CitizensImpl citizens = new CitizensImpl(personList);

        assertEquals(5, citizens.size());
    }

    @Test
    void add() {
        assertFalse(citizens.add(null));
        assertFalse(citizens.add(new Person(2, "John", "Jackson", now.minusYears(20))));
        assertEquals(4, citizens.size());
        assertTrue(citizens.add(new Person(5, "John", "Jackson", now.minusYears(20))));
        assertEquals(5, citizens.size());
    }

    @Test
    void remove() {
        assertFalse(citizens.remove(5));
        assertEquals(4, citizens.size());
        assertTrue(citizens.remove(4));
        assertEquals(3, citizens.size());
    }

    @Test
    void findById() {
        Person person = citizens.findById(1);
        assertEquals(1, person.getId());
        assertEquals("Peter", person.getFirstName());
        assertEquals("Jackson", person.getLastName());
        assertEquals(23, person.getAge());
        assertNull(citizens.findById(5));
    }

    @Test
    void testFindByLastname() {
        Iterable<Person> persons = citizens.findLastName("Jackson");
        List<Person> actual = new ArrayList<>();
        for (Person person : persons) {
            actual.add(person);
        }
        Collections.sort(actual);
        List<Person> expected = List.of(
                new Person(1, "Peter", "Jackson", now.minusYears(23)),
                new Person(3, "Mary", "Jackson", now.minusYears(23))
        );
        assertIterableEquals(expected, actual);
    }

    @Test
    void findAgeByRange() {
        Iterable<Person> people = citizens.findAgeByRange(20, 23);
        List<Person> actual = new ArrayList<>();
        for (Person person : people) {
            actual.add(person);
        }
        Collections.sort(actual);
        List<Person> expected = List.of(
                new Person(1, "Peter", "Jackson", now.minusYears(23)),
                new Person(2, "John", "Smith", now.minusYears(20)),
                new Person(3, "Mary", "Jackson", now.minusYears(23)));
        assertIterableEquals(expected, actual);
    }

    @Test
    void getAllPersonsSortedById() {
        Iterable<Person> people = citizens.getAllPersonsSortedById();
        int id = 0;
        int count = 0;
        for (Person person : people) {
            count++;
            assertTrue(person.getId() > id);
            id = person.getId();
        }
        assertEquals(citizens.size(), count);
    }

    @Test
    void getAllPersonsSortedByAge() {
        Iterable<Person> people = citizens.getAllPersonsSortedByAge();
        int age = 0;
        int count = 0;
        for (Person person : people) {
            count++;
            assertTrue(person.getAge() >= age);
            age = person.getId();
        }
        assertEquals(citizens.size(), count);
    }

    @Test
    void getAllPersonsSortedByLastname() {
        Iterable<Person> people = citizens.getAllPersonsSortedByLastname();
        String lastname = "";
        int count = 0;
        for (Person person : people) {
            count++;
            assertTrue(person.getLastName().compareTo(lastname) >= 0);
            lastname = person.getLastName();
        }
        assertEquals(citizens.size(), count);
    }

    @Test
    void size() {
        assertEquals(4, citizens.size());
    }
}