package main.lesson_20.classwork.library.book.dao;

import main.lesson_20.classwork.library.book.model.Book;

public class Library {
    private Book[] books;
    private int size;

    public Library(int capacity) {
        books = new Book[capacity];
    }

    public boolean addBooks(Book book) {
        if (size == books.length || findBook(book.getIsbn()) != null) { // если размер равен длине массива то закончить работу
            return false;                                               // если isbn не равен null то закончить работу
        }
        books[size] = book;
        size++;
        return true;
    }

    public void printBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
        System.out.println("=============================================");
    }

    public int getSize() {
        return size;
    }

    public Book findBook(long isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                return books[i];
            }
        }
        return null;
    }

    public Book removeBook(long isbn) {
        Book victim = null;
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {           // если isbn равен тому isbn который ищем
                victim = books[i];                      // найденнный элемент вставляем во временную variable
                books[i] = books[size - 1];             // если размер 5, то берем 4 элемент и присваиваем в найденный элемент
                books[size - 1] = null;                 // в последний элемент присваиваем null
                size--;                                 // размер с 5 уменьшаем на один
                break;
            }
        }
        return victim;
    }
}















