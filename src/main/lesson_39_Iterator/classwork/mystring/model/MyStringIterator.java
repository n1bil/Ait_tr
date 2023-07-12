package main.lesson_39_Iterator.classwork.mystring.model;

import java.util.Iterator;

public class MyStringIterator implements Iterator<Character> {

    private StringBuilder str;
//    private int size;
    private int currentPosition;

    public MyStringIterator(StringBuilder str) {
        this.str = str;
//        size = str.length();
//        currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < str.length();
    }

    @Override
    public Character next() {
        Character curCharacter = str.charAt(currentPosition);
        currentPosition++;
        return curCharacter;
    }

    @Override
    public void remove() {
        str.deleteCharAt(--currentPosition);
//        size--;
    }
}
