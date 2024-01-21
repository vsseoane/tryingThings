package com.veroprojects.TryingThings.controller;


import com.veroprojects.TryingThings.dto.StudentDto;
import com.veroprojects.TryingThings.model.Student;
import com.veroprojects.TryingThings.service.IStudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

        private IStudentService studentService;

        @Autowired
        public StudentController(IStudentService studentService) {
                this.studentService = studentService;
        }

        @GetMapping("/students/{student_id}")
        public ResponseEntity<StudentDto> getStudentById(@PathVariable final int student_id) {
                return ResponseEntity.ok(studentService.getStudentById(student_id));
        }

        @GetMapping("/students")
        public ResponseEntity<List<StudentDto>> getStudents() {
                return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
        }

        @PostMapping("/students")
        public ResponseEntity<StudentDto> createStudent(@RequestBody final StudentDto studentDto) {
                return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
        }

        @PutMapping("/students/{student_id}")
        public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto student, @PathVariable int student_id) {
                StudentDto studentDto = studentService.updateStudent(student, student_id);
                return new ResponseEntity<>(studentDto, HttpStatus.OK);
        }

        @DeleteMapping("/students/{student_id}")
        public ResponseEntity<String> deleteStudent(@PathVariable int student_id) {
                studentService.deleteStudent(student_id);
                return new ResponseEntity<>("Student deleted", HttpStatus.OK);
        }

}
