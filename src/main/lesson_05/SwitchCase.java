package main.lesson5;

public class SwitchCase {
    public static void main(String[] args) {
        fan1(1);
    }

    public static void fan(int mode) {
        if (mode == 0) {
            System.out.println("Off");
            return;
        }
        if (mode == 1) {
            System.out.println("Slow");
            return;
        }
        if (mode == 2) {
            System.out.println("Medium");
            return;
        }
        if (mode == 3) {
            System.out.println("Fast");
            return;
        }
        System.out.println("Something went wrong");
    }

    public static void fan1(int mode) {
        switch (mode) {
            case 0:
                System.out.println("Off");
                break;
            case 1:
                System.out.println("Slow");
                break;
            case 2:
                System.out.println("Medium");
                break;
            case 3:
                System.out.println("Fast");
                break;
            default:
                System.out.println("Something went wrong");
        }
        System.out.println("Method fan1 is finished");
    }

    // oper == 1 это значит плюс (+), oper == 2 это значит вычитание (-) oper == 3 это значит умножение (*) oper == 4 это значит деление (/) или
    // other print "Wrong operation"
    public static void calculator(int value1, int value2, int oper) {
        if (oper == 1) {
            System.out.println(value1 + value2);
        } else if (oper == 2) {
            System.out.println(value1 - value2);
        } else if (oper == 3) {
            System.out.println(value1 * value2);
        } else if (oper == 4) {
            System.out.println(value1 / value2);
        }
        System.out.println("Something went wrong");
    }
}













