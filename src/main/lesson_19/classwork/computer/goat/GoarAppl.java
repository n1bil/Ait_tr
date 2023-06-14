package main.lesson_19.classwork.computer.goat;

import main.lesson_19.classwork.computer.goat.model.Goat;

public class GoarAppl {
    public static void main(String[] args) {
        Goat goating1 = new Goat(10);
        for (int i = 0; i < goating1.getMax(); i++) {
            goating1.incrementCount();
        }
        System.out.println("goatling1.count = " + goating1.getCount());

        Goat goating2 = new Goat(15);
        for (int i = 0; i < goating2.getMax(); i++) {
            goating2.incrementCount();
        }
        System.out.println("goatling1.count = " + goating2.getCount());
        System.out.println("goatling2.count = " + goating1.getCount());
//        int[] arr = new int[5];
//        System.out.println(arr.length);
//        arr.length = 10;
        System.out.println(Goat.GOAT_LIMIT);
        System.out.println(Math.PI);
    }
}
