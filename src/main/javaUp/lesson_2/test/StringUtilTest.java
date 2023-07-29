package main.javaUp.lesson_2.test;

import main.javaUp.lesson_2.util.StringUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilTest {

    @Test
    void generateLowerCharacters() {
        String result = StringUtil.generateLowerCharters();

        String expectedResult = "abcdefghijklmnopqrstuvwxyz";

        assertEquals(expectedResult, result);
    }
}