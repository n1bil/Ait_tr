package main.lesson_39_Iterator.homework.fibonacci.model;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

    private int length;
    private int  currentPosition;

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
        return currentPosition++;
    }
}
