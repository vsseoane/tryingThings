package com.veroprojects.TryingThings.controller;

import com.veroprojects.TryingThings.dto.ReviewDto;
import com.veroprojects.TryingThings.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private IReviewService reviewService;
    @Autowired
    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/students/{student_id}/reviews")
    public ResponseEntity<List<ReviewDto>> getReviewsByStudentId(@PathVariable int student_id) {
        return new ResponseEntity<>(reviewService.getReviewsByStudentId(student_id), HttpStatus.OK);
    }

    @PostMapping("/students/{student_id}/reviews")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto, @PathVariable int student_id) {
        return new ResponseEntity<>(reviewService.createReview(reviewDto, student_id), HttpStatus.OK);
    }

    @DeleteMapping("/students/{student_id}/reviews/{review_id}")
    public ResponseEntity<String> deleteReview(@PathVariable int student_id, @PathVariable int review_id) {
        reviewService.deleteReviewsStudentId(student_id, review_id);
        return new ResponseEntity<>("Reviews were deleted", HttpStatus.OK);
    }






}
