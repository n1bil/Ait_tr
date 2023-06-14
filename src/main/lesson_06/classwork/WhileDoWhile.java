package main.lesson_06.classwork;

public class WhileDoWhile {
    public static void main(String[] args) {
        countdown();
        System.out.println(exponentiation(2, 4));
        separateDigits(3679);
        separateString("hello");
    }

    // task 1
    public static void countdown() {
        int i = 10;
        while (i >= 0) {
            System.out.print(i + " ");
            --i;
        }
        System.out.println();
    }

    // task 2
    public static int exponentiation(int value, int exponent) {
        int result = 1;
        int i = 1;
        while (i <= exponent) {
            i++;
            result *= value;
        }
        return result;
    }

    // task 3
    public static void separateDigits(int number) {
        int reverseNumber = 0;
        while (number > 0) {
            reverseNumber = reverseNumber * 10 + (number % 10);
            number /= 10;
        }
        while (reverseNumber > 0) {
            int digit = reverseNumber % 10;
            System.out.print(digit + " ");
            reverseNumber /= 10;
        }
        System.out.println();
    }

    // task 4
    public static void separateString(String str) {
        int i = 0;
        while (i < str.length()) {
            char letter = str.charAt(i);
            System.out.print(letter + " ");
            i++;
        }
    }
}




