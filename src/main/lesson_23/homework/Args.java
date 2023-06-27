package main.lesson_23.homework;

public class Args {
    public static void main(String[] args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                printMinMaxValues(args[i]);
            }
        } else {
            printAllValues();
        }
    }

    public static void printMinMaxValues(String type) {
        switch (type) {
            case "byte":
                System.out.println(Byte.MIN_VALUE);
                System.out.println(Byte.MAX_VALUE);
                break;
            case "short":
                System.out.println(Short.MIN_VALUE);
                System.out.println(Short.MAX_VALUE);
                break;
            case "char":
                System.out.println((int) Character.MIN_VALUE);
                System.out.println((int) Character.MAX_VALUE);
                break;
            case "int":
                System.out.println(Integer.MIN_VALUE);
                System.out.println(Integer.MAX_VALUE);
                break;
            case "long":
                System.out.println(Long.MIN_VALUE);
                System.out.println(Long.MAX_VALUE);
                break;
            case "float":
                System.out.println(Float.MIN_VALUE);
                System.out.println(Float.MAX_VALUE);
                break;
            case "double":
                System.out.println(Double.MIN_VALUE);
                System.out.println(Double.MAX_VALUE);
                break;
            default:
                System.out.println("Wrong type");
        }
    }

    public static void printAllValues() {
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println((int) Character.MIN_VALUE);
        System.out.println((int) Character.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
    }
}

