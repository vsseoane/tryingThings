package com.veroprojects.TryingThings.controller;


import com.veroprojects.TryingThings.dto.StudentDto;
import com.veroprojects.TryingThings.model.Student;
import com.veroprojects.TryingThings.service.IStudentService;
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
        @PostMapping("/student")
        public ResponseEntity<StudentDto> createStudent(@RequestBody final StudentDto studentDto) {
                return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
        }


        @GetMapping("/student")
        public ResponseEntity<List<StudentDto>> getAllStudents() {
                return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
        }

        @GetMapping("/student/{id}")
        public Student getStudentById(@PathVariable final String id) {
                Student student1 = new Student(1, "Romi", new BigDecimal("2323"));
                return student1;
        }

        @PatchMapping("/student")
        public void patchStudent(@RequestBody Student student) {
                System.out.println(student);
        }

        @DeleteMapping("/student/{id}")
        public void patchStudent(@RequestBody String id) {
                System.out.println(id);
        }

}
