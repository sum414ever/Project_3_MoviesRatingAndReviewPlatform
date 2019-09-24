package edu.curssor.moviesPlatform.service.implementation;

import edu.curssor.moviesPlatform.dto.MovieWithReviewDTO;
import edu.curssor.moviesPlatform.entities.Movie;
import edu.curssor.moviesPlatform.entities.Rate;
import edu.curssor.moviesPlatform.enums.Category;
import edu.curssor.moviesPlatform.exeptions.DataNotFoundException;
import edu.curssor.moviesPlatform.repository.MovieRepository;
import edu.curssor.moviesPlatform.repository.ReviewRepository;
import edu.curssor.moviesPlatform.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Movie save(Movie movieDTO) {

        Movie movie = new Movie();

        movie.setName(movieDTO.getName());
        movie.setDirector(movieDTO.getDirector());
        movie.setDescription(movieDTO.getDescription());
        movie.setCategoryDB(Category.getCategoryFromString(movieDTO.getCategory()));
        movie.setRate(movieDTO.getRate());

        movieRepository.save(movie);
        return movieDTO;
    }

    @Override
    public void deletedMovieById(String id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie findMovieById(String id) {
        return movieRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Movie with id " + id + " not found"));
    }

    @Override
    public Movie updateMovieById(String id, Movie movieDTO) {

        Movie editedMovie = findMovieById(id);

        String newName = Objects.nonNull(movieDTO.getName())
                ? movieDTO.getName()
                : editedMovie.getName();
        editedMovie.setName(newName);

        String newDirector = Objects.nonNull(movieDTO.getDirector())
                ? movieDTO.getDirector()
                : editedMovie.getDirector();
        editedMovie.setDirector(newDirector);

        String newDescription = Objects.nonNull(movieDTO.getDescription())
                ? movieDTO.getDescription()
                : editedMovie.getDescription();
        editedMovie.setDescription(newDescription);

        Rate newRate = Objects.nonNull(movieDTO.getRate())
                ? movieDTO.getRate()
                : editedMovie.getRate();
        editedMovie.setRate(newRate);

        return movieRepository.save(editedMovie);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public MovieWithReviewDTO getMovieWithReviews(String id) {
        MovieWithReviewDTO movie = new MovieWithReviewDTO();
        movie.setMovie(findMovieById(id));
        movie.setReviews(reviewRepository.findAllByMovieId(id));
        return movie;
    }

    @Override
    public List<Movie> getMovieByCategory(String category) {
        Category cat = Category.getCategoryFromString(category);
        return movieRepository.findAllByCategoryDB(cat);
    }

    @Override
    public List<Movie> getAllMovieByHighestRating() {

        return movieRepository.findAll().stream()
                .sorted(Comparator.comparing(movie -> movie.getRate().getAvgRate(),Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> getAllMovieByLowestRating() {
        return movieRepository.findAll().stream()
                .sorted(Comparator.comparing(movie -> movie.getRate().getAvgRate()))
                .collect(Collectors.toList());
    }
}
