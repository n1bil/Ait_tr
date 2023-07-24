package main.lesson_47_LinkedList.classwork.list.model;

import main.lesson_47_LinkedList.classwork.list.interfaces.IList;

import java.util.Iterator;

public class MyLinkedList<E> implements IList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(last, element, null);
        if (last != null) {                 // проверяется если последний не пустой, то значит что в последнем уже есть элементы
            last.next = newNode;            // то назначаем последнему следующему наш новый узел
        } else {                            // если последний пустой, это означает что в списке нет элементов
            first = newNode;                // тогда назначаем наш новый узел на первое узел
        }
        last = newNode;                     // затем ссылка last устанавливается на новый узел 'newCode'
        size++;
        return true;
    }

    // 0(n), 0(1) - for last and first
    @Override
    public boolean add(int index, E element) {
        if (index == size) {
            return add(element);
        }
        Node<E> node = getNodeByIndex(index);
        Node<E> newNode = new Node<>(node.prev, element, node);
        node.prev = newNode;
        if (index != 0) {
            newNode.prev.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return false;
    }

    // 0(n)
    @Override
    public E get(int index) {
        Node<E> node = getNodeByIndex(index);
        return node.data;
    }

    // 0(n)
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o != null) {
            for (Node<E> node = first; node != null; node = node.next, index++) {
                if (o.equals(node.data)) {
                    return index;
                }
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next, index++) {
                if (o == node.data) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (o != null) {
            for (Node<E> node = last; node != null; node = node.prev, index--) {
                if (o.equals(node.data)) {
                    return index;
                }
            }
        } else {
            for (Node<E> node = last; node != null; node = node.prev, index--) {
                if (o == node.data) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        //TODO
        return null;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        Node<E> node = getNodeByIndex(index);
        E oldValue = node.data;
        node.data = element;
        return oldValue;
    }

    @Override
    public Iterator<E> iterator() {
        //TODO
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }

    private Node<E> getNodeByIndex(int index) {
        checkIndex(index);
        Node<E> node;
        if (index < size / 2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    // 0(1)
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }
}
