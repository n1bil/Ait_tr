package main.lesson_39_Iterator.homework.fibonacci;

import main.lesson_39_Iterator.homework.fibonacci.model.Fibonacci;

public class FibonacciAppl {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(8);
        //TODO print all numbers, and reduce sum
        //1,1,2,3,5,8,13,21
        //sum = 54
        int sum = 0;

        for (int integer : fibonacci) {
            System.out.print(integer + " ");
            sum += integer;
        }
        System.out.println("\n" + "Sum = " + sum);
    }

}
