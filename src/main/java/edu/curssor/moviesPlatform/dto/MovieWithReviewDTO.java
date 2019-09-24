package edu.curssor.moviesPlatform.dto;

import edu.curssor.moviesPlatform.entities.Movie;
import edu.curssor.moviesPlatform.entities.Review;
import lombok.Data;

import java.util.List;

@Data
public class MovieWithReviewDTO {

    private Movie movie;

    private List<Review> reviews;
}
