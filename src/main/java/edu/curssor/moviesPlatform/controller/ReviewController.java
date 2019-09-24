package edu.curssor.moviesPlatform.controller;

import edu.curssor.moviesPlatform.entities.Review;
import edu.curssor.moviesPlatform.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("review/movie")
    public ResponseEntity<Review> addReview (@RequestBody Review review){
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(reviewService.save(review));
    }
}

