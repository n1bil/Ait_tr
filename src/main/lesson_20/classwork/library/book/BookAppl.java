package main.lesson_20.classwork.library.book;

import main.lesson_20.classwork.library.book.dao.Library;
import main.lesson_20.classwork.library.book.model.Book;

public class BookAppl {
    public static void main(String[] args) {
        Library library = new Library(10);
        library.addBooks(new Book(2000000000000L, "Book0", 1988));
        library.addBooks(new Book(3000000000000L, "Book1", "Author1" ,1995));
        System.out.println(library.getSize());
        library.addBooks(new Book(4000000000000L, "Book2", "Author2" ,1996));
        library.addBooks(new Book(5000000000000L, "Book3", "Author3" ,1999));
        library.addBooks(new Book(6000000000000L, "Book4",1981));

        System.out.println(library.getSize());
        System.out.println(library.addBooks(new Book(6000000000000L, "Book4",1981)));
        System.out.println(library.getSize());
        library.printBooks();
        Book book = library.findBook(5000000000000L);
        System.out.println(book);
        book = library.findBook(9000000000000L);
        System.out.println(book);

        library.removeBook(3000000000000L);
        System.out.println(library.getSize());
        library.printBooks();
    }
}
