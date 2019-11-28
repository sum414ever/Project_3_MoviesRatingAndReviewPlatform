package edu.curssor.moviesPlatform.repository;

import edu.curssor.moviesPlatform.entities.Movie;
import edu.curssor.moviesPlatform.enums.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findAllByCategory(Category category);
}
