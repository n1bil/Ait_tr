package main.lesson_50_HashSet.classwork.set.model;

public interface ISet<E> extends Iterable<E> {

    boolean add(E element);

    boolean contains(E element);

    boolean remove(E element);

    int size();
}
