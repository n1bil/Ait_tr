package main.lesson_48.homework.citizens.test;

import main.lesson_48.homework.citizens.dao.Citizens;
import main.lesson_48.homework.citizens.dao.CitizensImpl;
import main.lesson_48.homework.citizens.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensTest {

    private Citizens citizens;
    List<Person> citizensList;

    @BeforeEach
    void setUp() {
        citizens = new CitizensImpl();
        citizensList = new ArrayList<>();
        citizensList.add(new Person(1, "Steve", "Robertson", LocalDate.of(1974, 3, 12)));
        citizensList.add(new Person(2, "Mike", "Davidson", LocalDate.of(2001, 6, 3)));
        citizensList.add(new Person(3, "Daniel", "Robertson", LocalDate.of(1999, 6, 21)));
        citizensList.add(new Person(4, "Tom", "Jackson", LocalDate.of(1974, 12, 3)));
        for (Person person : citizensList) {
            citizens.add(person);
        }
    }

    @Test
    void add() {
        assertFalse(citizens.add(null));
        assertEquals(4 , citizens.size());
        assertFalse(citizens.add(new Person(3, "Ted", "Thompson", LocalDate.of(2000, 12, 12))));
        assertTrue(citizens.add(new Person(5, "Randy", "Richardson", LocalDate.of(1990, 1, 2))));
        assertEquals(5 , citizens.size());
    }

    @Test
    void remove() {
        assertThrows(IndexOutOfBoundsException.class, () -> citizens.remove(5));
        assertTrue(citizens.remove(3));
        assertEquals(3, citizens.size());
    }

    @Test
    void find() {
        assertThrows(IndexOutOfBoundsException.class, () -> citizens.find(5));
        assertSame(citizensList.get(2), citizens.find(3));
    }

    @Test
    void testFind() {
        Iterable<Person> expected = citizens.find(22, 24);
        Iterable<Person> actual = List.of(citizensList.get(1), citizensList.get(2));
        assertIterableEquals(expected, actual);
    }

    @Test
    void lastName() {
        Iterable<Person> expected = citizens.lastName("Robertson");
        Iterable<Person> actual = List.of(citizensList.get(0), citizensList.get(2));
        assertIterableEquals(expected, actual);
    }

    @Test
    void getAllPersonsSortedById() {
        List<Person> expected = new ArrayList<>(citizensList);
        Collections.sort(expected);

        Iterable<Person> actual = citizens.getAllPersonsSortedById();
        assertIterableEquals(expected, actual);
    }

    @Test
    void getAllPersonsSortedByAge() {
        List<Person> expected = new ArrayList<>(citizensList);
        Collections.sort(expected, (o1, o2) -> o1.getAge() - o2.getAge());

        Iterable<Person> actual = citizens.getAllPersonsSortedByAge();
        assertIterableEquals(expected, actual);
    }

    @Test
    void getAllPersonsSortedByLastname() {
        List<Person> expected = new ArrayList<>(citizensList);
        Collections.sort(expected, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        Iterable<Person> actual = citizens.getAllPersonsSortedByLastname();
        assertIterableEquals(expected, actual);
    }

    @Test
    void size() {
        assertEquals(4, citizens.size());
    }
}