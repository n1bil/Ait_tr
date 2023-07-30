package main.lesson_51.classworkHomework.movie;

import main.lesson_51.classworkHomework.movie.dao.MoviesCollection;
import main.lesson_51.classworkHomework.movie.dao.MoviesCollectionImpl;
import main.lesson_51.classworkHomework.movie.model.Movie;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MoviesCollection movies = new MoviesCollectionImpl();
        movies.addMovie(new Movie(1, "300 Spartans", "Steve", "History", LocalDate.of(2005, 11, 2)));
        movies.addMovie(new Movie(2, "Troy", "Mark", "History", LocalDate.of(2007, 3, 6)));
        movies.addMovie(new Movie(3, "Hidden Strike", "Steve", "Action", LocalDate.of(2023, 5, 5)));
        movies.addMovie(new Movie(4, "Great White", "Steve", "History", LocalDate.of(2020, 11, 2)));
        movies.addMovie(new Movie(5, "Mask", "Brad", "Comedy", LocalDate.of(2000, 5, 9)));
        // will not be added because imdb is repeated
        movies.addMovie(new Movie(3, "Titanic", "David", "Drama", LocalDate.of(2015, 8, 22)));
        System.out.println("====== All movies ======");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        System.out.println("====== Movies in the last five years ======");
        movies.findMoviesCreatedBetweenDates(LocalDate.now().minusYears(5), LocalDate.now()).forEach(System.out::println);
    }
}