package edu.curssor.moviesPlatform.service;

import edu.curssor.moviesPlatform.dto.MovieWithReviewDTO;
import edu.curssor.moviesPlatform.entities.Movie;

import java.util.List;

public interface MovieService {

    Movie save(Movie movie);

    void deletedMovieById(String id);

    Movie findMovieById(String id);

    Movie updateMovieById(String id, Movie movie);

    List<Movie> getAll();

    MovieWithReviewDTO getMovieWithReviews(String id);

    List<Movie> getMovieByCategory(String category);

    List<Movie> getAllMovieByRating(int sortedParameter);
}
