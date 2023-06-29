package main.lesson_30_Comporator.classwork.arrays.test;

import main.lesson_30_Comporator.classwork.arrays.soldier.model.Soldier;
import main.lesson_30_Comporator.classwork.arrays.utils.ArrayTools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayToolsTest {

    Integer[] arrNum;
    String[] arrStr;
    Soldier[] soldiers;

    @BeforeEach
    void setUp() {
        arrNum = new Integer[]{9, 7, 4, 7, 2, 9, 5, 1, 0};
        arrStr = new String[]{"one", "two", "three", "four", "five"};
        soldiers = new Soldier[]{
                new Soldier("John", 182, 82.3, 91),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("Rabindranat", 162, 69.3, 82),
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Ann", 162, 55, 88)
        };
    }

    @Test
    void testPrintArray() {
        System.out.println("====== testPrintArray ======");
        ArrayTools.printArray(arrNum);
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testSearch() {
        System.out.println("====== testSearch ======");
        int index = ArrayTools.search(arrStr, "four");
        System.out.println("index = " + index);
        index = ArrayTools.search(arrStr, "six");
        System.out.println("index = " + index);
    }

    @Test
    void testFindByPredicate() {
        System.out.println("====== testFindByPredicate ======");
        Integer res = ArrayTools.findByPredicate(arrNum, integer -> integer < 5);
        System.out.println("Result = " + res);
        res = ArrayTools.findByPredicate(arrNum, integer -> integer % 5 == 0);
        System.out.println("Result = " + res);
        String str = ArrayTools.findByPredicate(arrStr, s -> s.length() == 4);
        System.out.println(str);

    }

    @Test
    void testBubbleSort() {
        System.out.println("====== testBubbleSort ======");
        ArrayTools.bubbleSort(arrNum);
        ArrayTools.printArray(arrNum);
        ArrayTools.bubbleSort(arrStr);
        ArrayTools.printArray(arrStr);
        ArrayTools.printArray(soldiers);
        ArrayTools.bubbleSort(soldiers);
        ArrayTools.printArray(soldiers);
    }

    @Test
    void testSortSoldierByName() {
        System.out.println("====== testSortSoldierByName ======");
//        ArrayTools.bubbleSort(soldiers, (soldier1, soldier2) -> soldier1.getName().compareTo(soldier2.getName()));
        Arrays.sort(soldiers, (soldier1, soldier2) -> soldier1.getName().compareTo(soldier2.getName()));
        ArrayTools.printArray(soldiers);
    }

    @Test
    void testSortSoldiers() {
        System.out.println("====== testSortSoldierByName ======");
        Arrays.sort(soldiers);
        ArrayTools.printArray(soldiers);
    }

    @Test
    void testSortString() {
        System.out.println("====== testSortString ======");
        Arrays.sort(arrStr);
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testSortStringByLength() {
        System.out.println("====== testSortStringByLength ======");
        Arrays.sort(arrStr, (s1, s2) -> s2.length() - s1.length());
        ArrayTools.printArray(arrStr);
    }
}















