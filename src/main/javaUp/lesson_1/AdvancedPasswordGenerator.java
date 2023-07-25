package main.javaUp.lesson_1;

import java.util.Random;

public class AdvancedPasswordGenerator {
    private static final int PASS_LENGTH = 12;

    public static void main(String[] args) {

        final String password = generatePassword(PASS_LENGTH);

        System.out.println(password);
    }

    private static String generatePassword(final int passLength) {
        final Random random = new Random();

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < passLength; i++) {
            buffer.append(getRandomSymbol(random));
        }

        return buffer.toString();
    }

    private static char getRandomSymbol(Random random) {
        int min = 32;
        int max = 125;
        return (char) (random.nextInt(max - min) + min);

    }
}
