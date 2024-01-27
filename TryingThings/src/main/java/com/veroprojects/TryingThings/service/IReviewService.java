package com.veroprojects.TryingThings.service;

import com.veroprojects.TryingThings.dto.ReviewDto;
import com.veroprojects.TryingThings.dto.StudentDto;

import java.util.List;

public interface IReviewService {

    String nameInterface = "455";
    static int num = 0;
    ReviewDto createReview(ReviewDto reviewDto, int studentId);

    List<ReviewDto> getReviewsByStudentId(int studentId);

    void deleteReviewsStudentId(int studentId, int reviewId);

    static void doSomething() {
        System.out.println("I am in doSomething");
    }
}
