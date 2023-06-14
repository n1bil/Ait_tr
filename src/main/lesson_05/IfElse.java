package main.lesson5;

public class IfElse {
    public static void main(String[] args) {
//        int height = 185;
//        System.out.println(height);
//        if (height > 192) {
//            System.out.println("I'm very tall");
//        } else {
//            System.out.println("I'm short");
//        }
//        System.out.println("My height: " + height);
//        double result = max(8.5, 8.8);
//        System.out.println("Max = " + result);
//        int digit = sign(5.5);
//        System.out.println("Sing = " + digit);
//        int digit2 = sign(-2.3);
//        System.out.println("Sing = " + digit2);
//        int digit3 = sign(0);
//        System.out.println("Sing = " + digit3);
        double result;
        result = taxUkraine(900);
        System.out.println("Tax in Ukraine = " + result);
        result = taxUkraine(3000);
        System.out.println("Tax in Ukraine = " + result);
        result = salaryNet(10000);
        System.out.println("Tax in Ukraine = " + result);
    }

    public static double max(double value1, double value2) {
        double result;
        if (value1 > value2) {
            result = value1;
        } else {
            result = value2;
        }
        return result;
    }

    public static int sign(double value) {
        if (value > 0) {
            return 1;
        }
        if (value < 0) {
            return -1;
        }
        return 0;
//        int result = 0;
//        if (value > 0) {
//            return 1;
//        } else {
//            if (value < 0) {
//                result = -1;
//            } else {
//                result = 0;
//            }
//        }
//
//        return result;
    }

    public static double taxUkraine(double salary) {
        double result = 0;
        if (salary > 1000) {
            result = (salary - 1000) * 0.17;
        }

        return result;
    }

    public static double salaryNet(double salary) {
        return salary - taxUkraine(salary);
    }
}
















