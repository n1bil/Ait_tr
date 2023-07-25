package main.lesson_47_LinkedList.classworkHomework.list.model;

import main.lesson_47_LinkedList.classworkHomework.list.interfaces.IList;

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
        first = last = null;
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
        Node<E> node = getNodeByIndex(index);
        return (E) node;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNodeByIndex(index);           // получить узел списка по указаному индексу
        E oldValue = node.data;                         // сохранять текущее значение элемента этого узнала в переменную oldValue
        node.data = element;                            // значение узла node.data заменяется на новое значение element
        return oldValue;                                // возвращать старое значение
    }

    @Override
    public Iterator<E> iterator() {
        //TODO
        return new Iterator<E>() {
            Node<E> node = first;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E data = node.data;
                node = node.next;
                return data;
            }
        };
    }

    private Node<E> getNodeByIndex(int index) {
        checkIndex(index);
        Node<E> node;
        if (index < size / 2) {                         // если индекс в начале
            node = first;                               // перекладываем
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {                                        // если индекс в конце
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    // 0(1)
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {               // если индекс меньше нуля или больше размера
            throw new IndexOutOfBoundsException(index); // бросить ошибку
        }
    }

    private static class Node<E> {

        Node<E> prev;
        E data;
        Node<E> next;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}
