package main.lesson_54_MapAdv.classwork.words.test;

import static main.lesson_54_MapAdv.classwork.words.utils.Anagram.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
    String word = "electrocity";

    @Test
    void testIsAnagram() {
        assertTrue(isAnagram(word, "city"));
        assertTrue(isAnagram(word, "tic"));
        assertTrue(isAnagram(word, "City"));
        assertTrue(isAnagram(word, "rele"));
        assertTrue(isAnagram(word, "tele"));
    }

    @Test
    void testIsNotAnagram() {
        assertFalse(isAnagram(word, "tell"));
        assertFalse(isAnagram(word, "select"));
        assertFalse(isAnagram(word, "collect"));
        assertFalse(isAnagram(word, ""));
        assertFalse(isAnagram(word, null));
    }

}