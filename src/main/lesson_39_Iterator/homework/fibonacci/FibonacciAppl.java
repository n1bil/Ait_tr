package main.lesson_39_Iterator.homework.fibonacci;

import main.lesson_39_Iterator.homework.fibonacci.model.Fibonacci;

import java.util.Iterator;

public class FibonacciAppl {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(8);
        //TODO print all numbers, and reduce sum
        //1,1,2,3,5,8,13,21
        //sum = 54
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        int sum = 0;

        Iterator<Integer> iterator = fibonacci.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            n3 = n1 + n2;
            System.out.print(n2 + " ");
            n1 = n2;
            n2 = n3;
            sum += n1;
        }
        System.out.println("\n" + "Sum = " + sum);
    }
}
