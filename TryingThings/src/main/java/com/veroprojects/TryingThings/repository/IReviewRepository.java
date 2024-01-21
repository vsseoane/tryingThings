package com.veroprojects.TryingThings.repository;

import com.veroprojects.TryingThings.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReviewRepository extends JpaRepository<Review, Integer> {


    List<Review> findByStudentId(int studentID);
}
