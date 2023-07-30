package main.lesson_51.classworkHomework.movie.dao;

import main.lesson_51.classworkHomework.movie.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class MoviesCollectionImpl implements MoviesCollection {

    private Collection<Movie> movies;

    public MoviesCollectionImpl() {
        movies = new ArrayList<>();
    }

    @Override
    public boolean addMovie(Movie movie) {
        if (movie != null && !movies.contains(movie)) {     // additional condition
            movies.add(movie);
            return true;
        }
        return false;
    }

    @Override
    public Movie removeMovie(long imdb) {
        Movie movie = findById(imdb);
        movies.remove(movie);
        return movie;
    }

    @Override
    public Movie findById(long imdb) {
        for (Movie movie : movies) {
            if (movie.getImdb() == imdb) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Iterable<Movie> findByGenre(String genre) {
        return findByPredicate(movie -> movie.getGenre().equals(genre));
    }

    @Override
    public Iterable<Movie> findByDirector(String director) {
        return findByPredicate(movie -> movie.getDirector().equals(director));
    }

    @Override
    public Iterable<Movie> findMoviesCreatedBetweenDates(LocalDate from, LocalDate to) {
        return findByPredicate(movie -> movie.getDate().isAfter(from) && movie.getDate().isBefore(to));
    }

    @Override
    public int totalQuantity() {
        return movies.size();
    }

    private Iterable<Movie> findByPredicate(Predicate<Movie> predicate) {
        List<Movie> findByPredicate = new ArrayList<>();
        for (Movie movie : movies) {
            if (predicate.test(movie)) {
                findByPredicate.add(movie);
            }
        }
        return findByPredicate;
    }

    @Override
    public Iterator<Movie> iterator() {
        return movies.iterator();
    }
}
