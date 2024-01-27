package com.veroprojects.TryingThings.repository;

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
public class StudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;

    @Test
    public void StudentRepository_SaveAll_ReturnSavedStudent() {
        Student student = new Student("Tomas", new BigDecimal(3434));

        Student savedStudent = this.studentRepository.save(student);

        Assertions.assertThat(savedStudent).isNotNull();
        Assertions.assertThat(savedStudent.getId()).isGreaterThan(0);

    }

    @Test
    public void StudentRepository_findAll_ReturnsMoreTheOneStudent() {
        Student student = new Student("Tomas", new BigDecimal(3434));
        Student student2 = new Student("MArco", new BigDecimal(22222));

        this.studentRepository.save(student);
        this.studentRepository.save(student2);

        List<Student> students = this.studentRepository.findAll();

        Assertions.assertThat(students.size()).isEqualTo(2);

    }

    @Test
    public void StudentRepository_findById_ReturnsAStudent() {
        Student student = new Student("Tomas", new BigDecimal(3434));

        Student studentSaved = this.studentRepository.save(student);

        Student studentFound = this.studentRepository.getReferenceById(studentSaved.getId());

        Assertions.assertThat(studentFound).isNotNull();

    }


    @Test
    public void StudentRepository_updateStudent_ReturnsStudentUpdated() {

        Student student = new Student("Toms", new BigDecimal(3434));

        this.studentRepository.save(student);

        Student studentUpdated = this.studentRepository.getReferenceById(student.getId());
        studentUpdated.setName("Tomas");
        Assertions.assertThat(studentUpdated.getName()).isEqualTo("Tomas");

    }
}
