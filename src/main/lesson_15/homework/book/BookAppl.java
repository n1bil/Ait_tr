package main.lesson_15.homework.book;

import main.lesson_15.homework.book.model.Book;

public class BookAppl {
    public static void main(String[] args) {
        Book[] books = new Book[3];

        books[0] = new Book(1, "Java", "Herbert Schildt", 2018);

        books[1] = new Book(2, "Roman Empire", 1701);

        books[2] = new Book(3, "Universe");

        printBooks(books);
        Book oldestBook = findOldestBook(books);
        oldestBook.display();
        Book youngestBook = findYoungestBook(books);
        youngestBook.display();
    }

    public static Book findOldestBook(Book[] books) {
        Book result = books[0];
        for (int i = 1; i < books.length; i++) {
            if (result.getYearOfPublishing() > books[i].getYearOfPublishing()) {
                result = books[i];
            }
        }
        return result;
    }

    public static Book findYoungestBook(Book[] books) {
        Book result = books[0];
        for (int i = 1; i < books.length; i++) {
            if (result.getYearOfPublishing() < books[i].getYearOfPublishing()) {
                result = books[i];
            }
        }
        return result;
    }

    public static void printBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            books[i].display();
        }
    }
}
