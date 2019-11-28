package edu.curssor.moviesPlatform.repository;

import edu.curssor.moviesPlatform.entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findAllByMovieId(String id);
}
