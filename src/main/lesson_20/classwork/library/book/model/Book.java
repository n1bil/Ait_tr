package main.lesson_20.classwork.library.book.model;

import java.util.Objects;

public class Book {
    public static final int ISBN_LENGTH = 13;
    private final long isbn;
    private String title;
    private String author;
    private int yearOfPublishing;

    public Book(long isbn, String title, String author, int yearOfPublishing) {
        this.isbn = checkIsbn(isbn);
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public Book(long isbn, String title, int yearOfPublishing) {
        this.isbn = checkIsbn(isbn);
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        author = "unknown";
    }

    public long getIsbn() {
        return this.isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    private long checkIsbn(long isbn) {
        if (countDigits(isbn) == ISBN_LENGTH) {
            return isbn;
        }
        return -1;
    }

    private int countDigits(long isbn) {
        int count = 0;
        do {
            count++;
            isbn /= 10; // isbn = isbn / 10;
        } while (isbn != 0);
        return count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
