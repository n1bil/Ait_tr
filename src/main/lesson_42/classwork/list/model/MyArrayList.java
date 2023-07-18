package main.lesson_42.classwork.list.model;

import main.lesson_42.classwork.list.interfaces.IList;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements IList<E> {

    private Object[] elements; // хранилище элементов, массива object
    private int size;          // количество элементов, не размер массива!

    public MyArrayList() {
//        elements = new Object[10];
        this(10);           // конструктор, который создает первоначадбный массив длины 10
    }

    public MyArrayList(int initialCapacity) {   // конструктор с параметром, который принимает начальный размер массива
        if (initialCapacity < 0) {              // если начальный размер - отрицальное число - выбрасываем число
            throw new IllegalArgumentException("Illegal capacity = " + initialCapacity);
        }
        elements = new Object[initialCapacity]; // создаем массив нужного массива
    }

    // 0(1)
    @Override
    public int size() {
        return size; // вернуть размер
    }

    // 0(n)
    @Override
    public void clear() {       // обнуляем массив и размер 0

    }

    // метод add имеет 0(1) сложность, но из-за того что вызываем метод ensureCapacity(), тогда 0(n)
    @Override
    public boolean add(E element) {
        ensureCapacity();               // нам нужно гарантировать, что места хватит, поэтому вызываем данный метод
        elements[size] = element;     // добавляем элемент в конец списка
        size++;                         // добавили и увеличиваем размер массива
        return true;
    }

    // 0(n)
    private void ensureCapacity() {     // увеличивает размер массива
        if (size == elements.length) {  // если количество размер элементов и длина массива совпало
            if (size == Integer.MAX_VALUE) { // если мы дошли до максимального целого - выбрасываем ошибку
                throw new OutOfMemoryError();
            }
            int newCapacity = elements.length + elements.length / 2; // новая длина - в полтора раза больше предыдущей
            if (newCapacity < 0) {                                   // если было переполнение - то просто берем максимальное целон
                newCapacity = Integer.MAX_VALUE;
            }
            elements = Arrays.copyOf(elements, newCapacity);        // создаем копию массива нового размера
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
        checkIndex(index);      // проверяем адекватный ли индекс
        return (E) elements[index]; // возвращаем его
    }

    // 0(1)
    private void checkIndex(int index) {
        if (index < 0 || index >= size) { // проверяем, нормальный ли индекс
            throw new IndexOutOfBoundsException(index);
        }
    }

    // 0(n)
    @Override
    public int indexOf(Object o) {
        if (o != null) { // еслин ненулевой элемент
            for (int i = 0; i < size; i++) { // пробегаем все элементы массива
                if (o.equals(elements[i])) { // сравниваем через equals, если нашли элемент
                    return i; // возращаем резултат - индекс этого элемента
                }
            }
        } else {
            for (int i = 0; i < size; i++) { // если передали null, значит ищем null
                if (o == elements[i]) { // сравниваем через обычное ==, потому что equals
                    return i; // возвращаем индекс null-a
                }
            }
        }
        return -1; // возвращаем
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

    // 0(1)
    @Override
    public E set(int index, E element) {
            return (E) elements;
    }

    // 0(1)
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return (E) elements;
            }
        };
    }
}
