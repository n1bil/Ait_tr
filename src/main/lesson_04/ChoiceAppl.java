package main.lesson4;

public class ChoiceAppl {
    public static void main(String[] args) {
//        int age = 21;
//        double res = barmen(age);
//        printVol(res);
//        age = 15;
//        res = barmen(age);
//        printVol(res);
//        res = max(3.8, 5.4);
//        System.out.println("Max = " + res);
//        res = max(8.2, 8.1);
//        System.out.println("Max = " + res);
//        res = abs(5);
//        System.out.println("abs = " + res);
//        res = abs(-7);
//        System.out.println("abs = " + res);
//        res = abs(0);
//        System.out.println("abs = " + res);
//        int a = sign(5.5);
//        System.out.println("sign = " + a);
//        a = sign(-2.8);
//        System.out.println("sign = " + a);
//        a = sign(0);
//        System.out.println("sign = " + a);

        System.out.println("Min = " + min(6.5, 3.4));
//        System.out.println("Min = " + minNotUsingOperators(12.34, -54.33));

    }

//    public static double barmen(int age){
//        double vol = age >= 18 ? 42 : 1.5;
//        return vol;
//    }
//
//    public static void printVol(double vol){
//        System.out.println("You max. vol. = " + vol);
//    }
//
    public static double max(double x, double y){
        //  double res = x > y ? x : y;
        //  return res;
        return x > y ? x : y;
    }
//
    public static double abs(double x) {
        return x < 0 ? -x : x;
    }
//
//    public static int sign(double x) {
//        return x > 0 ? 1 : (x < 0 ? -1 : 0);
//    }

    public static double min(double value1, double value2) {

//        return value1 + value2 - max(value1, value2);
//        return -max(-value1, -value2);
//        return (value1 + value2 - abs(value1 - value2)) / 2;
        return max(value1, value2) - abs(value1 - value2);
    }

}












