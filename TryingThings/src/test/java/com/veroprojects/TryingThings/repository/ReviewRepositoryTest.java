package com.veroprojects.TryingThings.repository;

import com.veroprojects.TryingThings.model.Review;
import com.veroprojects.TryingThings.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.assertj.core.api.Assertions;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ReviewRepositoryTest {

    private IReviewRepository reviewRepository;
    private IStudentRepository studentRepository;

    @Autowired
    public ReviewRepositoryTest(IReviewRepository reviewRepository, IStudentRepository studentRepository) {
        this.reviewRepository = reviewRepository;
        this.studentRepository = studentRepository;

    }

    @Test
    public void ReviewRepository_save_ReturnsSavedReview() {

        Review review = new Review("Excelent Student", 9);
        Student student = new Student("Toms", new BigDecimal(3434));
        review.setStudent(student);
        this.reviewRepository.save(review);

        Assertions.assertThat(review).isNotNull();

    }


    @Test
    public void ReviewRepository_getReviewByStudentId_ReturnsSavedReview() {
        Review review = new Review("Excelent Student", 9);
        Student student = new Student("Toms", new BigDecimal(3434));

        review.setStudent(student);
        this.studentRepository.save(student);
        this.reviewRepository.save(review);

        List<Review> reviewsFound = this.reviewRepository.findByStudentId(student.getId());

        Assertions.assertThat(reviewsFound.size()).isEqualTo(1);
    }

}
