package main.lesson_31.classwork.test;

import main.lesson_31.classwork.model.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CatTest {

    Cat[] cats;

    @BeforeEach
    void setUp() {
        cats = new Cat[]{
                new Cat("Belka", 4, "red", 3),
                new Cat("Strelka", 3, "white", 6),
                new Cat("Belka", 5, "gray", 7),
                new Cat("Jerry", 6, "white", 6)
        };
    }

    @Test
    void testCatsSor() {
        System.out.println("======== testCatsSort ========");
        Arrays.sort(cats);
        printArray();
        Arrays.sort(cats, (Cat o1,Cat o2) -> {
            int comparatorName = o1.getName().compareTo(o2.getName());
            if (comparatorName != 0) {                  // если сортировка не равна по имени
                return comparatorName;                  // то вернуть по имени
            } else {
                return o1.getAge() - o2.getAge();       // иначе вернуть по возрасту
            }
        });
        printArray();
    }

    @Test
    void printArray() {
        System.out.println("======== printArray ========");
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
    }
}
