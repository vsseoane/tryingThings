package com.veroprojects.TryingThings.service.imp;

import com.veroprojects.TryingThings.dto.ReviewDto;
import com.veroprojects.TryingThings.exception.ReviewNotFoundException;
import com.veroprojects.TryingThings.exception.StudentNotFoundException;
import com.veroprojects.TryingThings.model.Review;
import com.veroprojects.TryingThings.model.Student;
import com.veroprojects.TryingThings.repository.IReviewRepository;
import com.veroprojects.TryingThings.repository.IStudentRepository;
import com.veroprojects.TryingThings.service.IReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService {

    IReviewRepository reviewRepository;
    IStudentRepository studentRepository;

    public ReviewService(IReviewRepository reviewRepository, IStudentRepository studentRepository) {
        this.reviewRepository = reviewRepository;
        this.studentRepository = studentRepository;
    }
    public ReviewDto createReview(ReviewDto reviewDto, int studentId) {

        Student student = this.studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student could not be found"));

        Review reviewToSave =  this.mapDtoToReview(reviewDto);
        reviewToSave.setStudent(student);
        this.reviewRepository.save(reviewToSave);

        ReviewDto reviewDtoResponse = this.mapReviewToDto(reviewToSave);
        return reviewDtoResponse;
    }

    public List<ReviewDto> getReviewsByStudentId(int studentId) {
        List<Review> reviews = this.reviewRepository.findByStudentId(studentId);
        return reviews.stream().map(r -> this.mapReviewToDto(r)).collect(Collectors.toList());
    }

    public void deleteReviewsStudentId(int studentId, int reviewId){
        this.studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student could not be found"));
        Review review = this.reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review could not be found"));
        this.reviewRepository.delete(review);
    }

    private ReviewDto mapReviewToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setDescription(review.getDescription());
        reviewDto.setScore(review.getScore());
        return reviewDto;

    }
    private Review mapDtoToReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setDescription(reviewDto.getDescription());
        review.setScore(reviewDto.getScore());
        return review;

    }
}
