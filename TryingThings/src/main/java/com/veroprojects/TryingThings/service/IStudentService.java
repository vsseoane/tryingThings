package com.veroprojects.TryingThings.service;

import com.veroprojects.TryingThings.dto.StudentDto;

import java.util.List;

public interface IStudentService {

    StudentDto createStudent(StudentDto studentDTO);

    List<StudentDto> getStudents();
}
