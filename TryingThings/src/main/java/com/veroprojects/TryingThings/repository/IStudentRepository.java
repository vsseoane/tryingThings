package com.veroprojects.TryingThings.repository;

import com.veroprojects.TryingThings.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
