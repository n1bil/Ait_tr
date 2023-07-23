package main.lesson_40_ArrayList.homework.list.model;

import main.lesson_40_ArrayList.homework.list.interfaces.IList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<E> implements IList<E> {

    private Object[] elements;
    private int size;

    public MyArrayList() {
//        elements = new Object[10];
        this(10);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity = " + initialCapacity);
        }
        elements = new Object[initialCapacity];
    }

    // 0(1)
    @Override
    public int size() {
        return size;
    }

    // 0(n)
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // метод add имеет 0(1) сложность, но из-за того что вызываем метод ensureCapacity(), тогда 0(n)
    @Override
    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    // 0(n)
    private void ensureCapacity() {
        if (size == elements.length) {
            if (size == Integer.MAX_VALUE) {
                throw new OutOfMemoryError();
            }
            int newCapacity = elements.length + elements.length / 2;
            if (newCapacity < 0) {
                newCapacity = Integer.MAX_VALUE;
            }
            elements = Arrays.copyOf(elements, newCapacity);        // создаем новый elements с новым capacity
        }
    }

    // метод add имеет 0(1) сложность, но из-за того что вызываем метод ensureCapacity(), тогда 0(n)
    @Override
    public boolean add(int index, E element) {
        ensureCapacity();
        if (element != null && elements.length != size && index >= 0 && index <= size) {
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
            return true;
        }
        return false;
    }

    // 0(1)
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    // 0(1)
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    // 0(n)
    @Override
    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o == elements[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 0(n)
    @Override
    public int lastIndexOf(Object o) {
        if (o != null) {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o == elements[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 0(n)
    @Override
    public E remove(int index) {
        contains(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        elements[size] = null;
        return (E) elements[index];
    }

    // 0(n)
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    // 0(1)
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int currentPosition = 0;
            @Override
            public boolean hasNext() {
                return currentPosition < size;
            }

            @Override
            public E next() {
                return (E) elements[currentPosition++];
            }
        };
    }
}
