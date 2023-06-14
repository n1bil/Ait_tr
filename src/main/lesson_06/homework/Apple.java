package main.lesson_06.homework;

import java.util.Scanner;

public class Apple {
    public static void main(String[] args) {
        // чтобы проверить какую-ту задачу, нужно раскомментировать метод один из шести метод

//        peelApples();
//        str();
//        sum();
        sportsman();
//        reverse();
//        happyTicket();
//        happyTicket();
    }

    // task 0
    public static void peelApples() {
        int value = 0;
        int countApples = 30;
        System.out.println("The bucket is empty");
        while (countApples >= 0) {
            System.out.println("Put the " + value + " apple in the bucket");
            value++;
            countApples--;
        }
        System.out.println("Pie apples processed");
    }

    // task 1
    public static void str() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String output = keyboard.nextLine();
        System.out.print("Enter the counter: ");
        int counter = keyboard.nextInt();
        int i = 0;
        while (i < counter) {
            i++;
            System.out.println(output);
        }
        System.out.println("Output " + i + " times the string " + "\"" + output + "\"");
    }

    // task 2
    public static void sum() {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter please the first value: ");
        int digit1 = keyboard.nextInt();
        System.out.print("Enter please the first value: ");
        int digit2 = keyboard.nextInt();

        int result = digit1 + digit2;
        System.out.println("Sum = " + result);
    }

    // task 3
    public static void sportsman() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the distance: ");
        int distance = keyboard.nextInt();
        System.out.print("Enter the target: ");
        int target = keyboard.nextInt();
        int counter = 0;
        while (distance < target) {
            counter++;
            System.out.println("The sportsman ran " + distance + " kilometers on the " + counter + " day");
            distance += distance * 1.1;
        }
        System.out.println("The sportsman ran " + target + " km in " + (counter + 1) + " days");
    }

    // task 4
    public static void reverse() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the value: ");
        int value = keyboard.nextInt();
        int i = 0;
        System.out.print("The value in reverse: ");
        while (i < value) {
            int reverse = value % 10;
            System.out.print(reverse);
            value /= 10;
        }
    }

    // task 5
    public static void happyTicket() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a six-digit bus ticket: ");
        String parseTicketInString = keyboard.nextLine();

        if (parseTicketInString.length() == 6) {
            String firstThreeNumbers = parseTicketInString.substring(0, 3);
            String lastThreeNumbers = parseTicketInString.substring(3);
            int result1 = 0;
            for (int i = 0; i < firstThreeNumbers.length(); i++) {
                int digit = Character.getNumericValue(firstThreeNumbers.charAt(i));
                result1 += digit;
            }
            int result2 = 0;
            for (int i = 0; i < lastThreeNumbers.length(); i++) {
                int digit = Character.getNumericValue(lastThreeNumbers.charAt(i));
                result2 += digit;
            }
            if (result1 == result2) {
                System.out.println("Lucky ticket!");
            } else {
                System.out.println("Not lucky ticket");
            }
        } else {
            System.out.println("You entered an invalid number");
        }
    }

}

























