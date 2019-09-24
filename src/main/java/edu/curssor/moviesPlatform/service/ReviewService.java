package edu.curssor.moviesPlatform.service;

import edu.curssor.moviesPlatform.entities.Review;

import java.util.List;

public interface ReviewService {

    Review save(Review review);

    List<Review> getAllByMovieId(String id);
}
