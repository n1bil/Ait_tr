package main.lesson_08.classwork;

public class LogicalOperationApp {
    public static void main(String[] args) {
        int result = productOfTwoDigitOddNumbers();
        System.out.println(result);
        army(28);
    }

    public static int productOfTwoDigitOddNumbers() {
        int result = 1;
        for (int i = 10; i < 100; i++) {
            if (i % 2 == 1 && i % 13 == 0) {
                    result = result * i;
            }
        }
        return result;
    }

    public static void army(int age) {
        if (age < 18 || age >= 45) {
            System.out.println("Relax");
        } else {
            System.out.println("Go to army");
        }
    }
}
