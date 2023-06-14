package main.lesson_19.homework.book.model;

public class Book {

    private static final int ISBN_LENGTH = 13;                     // my change to the 19th home lesson
    private final long isbn;                                       // my change to the 19th home lesson
    private String title;
    private String author;
    private int yearOfPublishing;

    public Book(long isbn, String title, String author, int yearOfPublishing) {
        String stringIsbn = String.valueOf(isbn);                  // conversion from number to String
        if (stringIsbn.length() == ISBN_LENGTH) {                  // check that isbn has 15 figures
            this.isbn = isbn;
        } else {
            this.isbn = -1;
        }
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public Book(long isbn, String title, int yearOfPublishing) {
        String stringIsbn = String.valueOf(isbn);
        if (stringIsbn.length() == ISBN_LENGTH) {                  // by analogy, check as in the default constructor
            this.isbn = isbn;
        } else {
            this.isbn = -1;
        }
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
    }

    public Book(long isbn, String title) {
        String stringIsbn = String.valueOf(isbn);
        if (stringIsbn.length() == ISBN_LENGTH) {                  // by analogy, check as in the default constructor
            this.isbn = isbn;
        } else {
            this.isbn = -1;
        }
        this.title = title;
    }

    public void display() {
        System.out.println("Isbn - " + isbn + "; Title - " + title + "; Author - " + author + "; Year of publishing - " + yearOfPublishing);
    }

    public long getIsbn() {
        return isbn;
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
                                                                    // delete set method because isbn field is final
    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                '}';
    }
}
