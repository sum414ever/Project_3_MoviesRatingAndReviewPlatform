package edu.curssor.moviesPlatform.service.implementation;

import edu.curssor.moviesPlatform.entities.Review;
import edu.curssor.moviesPlatform.repository.ReviewRepository;
import edu.curssor.moviesPlatform.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllByMovieId(String id) {
        return reviewRepository.findAllByMovieId(id);
    }
}
