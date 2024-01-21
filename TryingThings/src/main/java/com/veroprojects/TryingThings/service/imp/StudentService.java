package com.veroprojects.TryingThings.service.imp;

import com.veroprojects.TryingThings.dto.StudentDto;
import com.veroprojects.TryingThings.exception.StudentNotFoundException;
import com.veroprojects.TryingThings.model.Student;
import com.veroprojects.TryingThings.repository.IStudentRepository;
import com.veroprojects.TryingThings.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService implements IStudentService {

    private IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setStudentNumber(studentDto.getStudentNumber());

        Student newStudent = studentRepository.save(student);

        StudentDto studentResponse = new StudentDto();
        studentResponse.setId(newStudent.getId());
        studentResponse.setName(newStudent.getName());
        studentResponse.setStudentNumber(newStudent.getStudentNumber());
        return studentResponse;
    }

    @Override
    public List<StudentDto> getStudents() {
        List<Student> students = studentRepository.findAll();
        Student student = studentRepository.findById(343).orElseThrow( () -> new StudentNotFoundException("Student could not found by id"));
        return students.stream().map(s -> mapToDto(s)).collect(Collectors.toList());

    }

    private StudentDto mapToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setStudentNumber(student.getStudentNumber());
        studentDto.setId(student.getId());
        return studentDto;
    }
}
