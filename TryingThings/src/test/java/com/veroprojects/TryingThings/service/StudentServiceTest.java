package com.veroprojects.TryingThings.service;


import com.veroprojects.TryingThings.dto.StudentDto;
import com.veroprojects.TryingThings.model.Student;
import com.veroprojects.TryingThings.repository.IStudentRepository;
import com.veroprojects.TryingThings.service.imp.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    public void StudentService_createStudent() {
        StudentDto studentDto = new StudentDto("Juan", new BigDecimal(444));

        Student studentMock = new Student("Juan", new BigDecimal(444));

        when(studentRepository.save(Mockito.any(Student.class))).thenReturn(studentMock);



        StudentDto studentSaved = this.studentService.createStudent(studentDto);

        Assertions.assertThat(studentSaved.getStudentNumber()).isEqualTo(new BigDecimal(444));


    }

    @Test
    public void StudentService_getStudents_ReturnsStudentNotNull() {

    }


}
