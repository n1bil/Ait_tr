package main.javaUp.lesson_1.util;

public class StringUtil {

    public static String generateLowerCharters() {
        StringBuilder buffer = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            buffer.append(i);
        }
        return buffer.toString();
    }
}
