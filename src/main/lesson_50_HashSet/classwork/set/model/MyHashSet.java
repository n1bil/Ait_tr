package main.lesson_50_HashSet.classwork.set.model;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements ISet<E> {

    private LinkedList<E>[] hashset;
    private int size;
    private int capacity;
    private double loadFactor;

    public MyHashSet(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        hashset = new LinkedList[capacity];
    }

    public MyHashSet(int capacity) {
        this(capacity, 0.75);
    }

    public MyHashSet() {
        this(16, 0.75);
    }

    // 0(1)
    @Override
    public boolean add(E element) {
        if (size >= capacity * loadFactor) {
            rebuildArray();
        }
        int index = getIndex(element);              //
        if (hashset[index] == null) {               // если корзина под индексом пустая
            hashset[index] = new LinkedList<>();    // то создать корзину под этим индексом
        }
        if (hashset[index].contains(element)) {     // если такой элемент существует в этой корзине | максимум в корзине могут быть 3 элемента
            return false;                           // то false
        }
        hashset[index].add(element);                // если нет такого элемента, то добавлять
        size++;

        return true;
    }

    private void rebuildArray() {
        capacity = capacity * 2;
        LinkedList<E>[] newHashSet = new LinkedList[capacity];      // массив linkedList
        for (int i = 0; i < hashset.length; i++) {                  // по всему массиву
            if (hashset[i] != null) {                               // если null
                for (E e : hashset[i]) {                            // начинаю искать внутри корзины
                    int index = getIndex(e);
                    if (newHashSet[index] == null) {
                        newHashSet[index] = new LinkedList<>();
                    }
                    newHashSet[index].add(e);
                }
            }
        }
        hashset = newHashSet;
    }

    // 0(1)
    private int getIndex(E element) {
        int hashcode = element.hashCode();
        hashcode = hashcode >= 0 ? hashcode : -hashcode;
        return hashcode % capacity;
    }

    // 0(1)
    @Override
    public boolean contains(E element) {
        int index = getIndex(element);
        if (hashset[index] == null) {
            return false;
        }

        return hashset[index].contains(element);
    }

    // 0(1)
    @Override
    public boolean remove(E element) {
        int index = getIndex(element);
        if (hashset[index] == null) {
            return false;
        }
        boolean res = hashset[index].remove(element);
        if (res) {
            size--;
        }
        return res;
    }

    // 0(1)
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int column;
            int row;
            int totalCounter;
            @Override
            public boolean hasNext() {
                return totalCounter < size;
            }

            @Override
            public E next() {
                while (hashset[column] == null || hashset[column].isEmpty()) {
                    column++;
                }
                E res = hashset[column].get(row);
                totalCounter++;
                if (row < hashset[column].size() - 1) {
                    row++;
                } else {
                    row = 0;
                    column++;
                }
                return res;
            }
        };
    }

}
