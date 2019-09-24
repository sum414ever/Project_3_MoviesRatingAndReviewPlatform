package edu.curssor.moviesPlatform.controller;

import edu.curssor.moviesPlatform.dto.MovieWithReviewDTO;
import edu.curssor.moviesPlatform.entities.Movie;
import edu.curssor.moviesPlatform.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/admin/movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(movieService.save(movie));
    }

    @DeleteMapping("/admin/movie/{id}")
    public ResponseEntity deleteMovieById(@PathVariable String id){

        String deletedMovieName = movieService.findMovieById(id).getName();

        movieService.deletedMovieById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("The movie " + deletedMovieName + " deleted!");
    }

    @PutMapping("/admin/movie/{id}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable String id, @RequestBody Movie movie){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.updateMovieById(id, movie));
    }

    @GetMapping("/movie")
    public ResponseEntity<List<Movie>> getAllMovies(){

        List<Movie> allMovies = movieService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allMovies);
    }

    @GetMapping("movie/{id}")
    public ResponseEntity<MovieWithReviewDTO> getMovieWithReviews(@PathVariable String id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.getMovieWithReviews(id));
    }

    @GetMapping("movie/stats/{category}")
    public ResponseEntity<List<Movie>> getMovieByCategory(@PathVariable String category){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.getMovieByCategory(category));
    }

    @GetMapping("movie/stats/rating/highest")
    public ResponseEntity<List<Movie>> getAllMovieByHighestRating(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.getAllMovieByHighestRating());
    }

    @GetMapping("movie/stats/rating/lowest")
    public ResponseEntity<List<Movie>> getAllMovieByLowestRating(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.getAllMovieByLowestRating());
    }
}
