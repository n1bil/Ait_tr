package main.lesson_39_Iterator.homework.fibonacci.model;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

    private int length;
    private int currentPosition;
    private int number1 = 0;
    private int number2 = 1;

    public FibonacciIterator(int length) {
        this.length = length;
    }

    @Override
    public boolean hasNext() {
        //TODO
        return currentPosition < length;
    }

    @Override
    public Integer next() {
        //TODO
        int number3 = number1 + number2;
        number1 = number2;
        number2 = number3;
        currentPosition++;
        return number1;

    }
}
