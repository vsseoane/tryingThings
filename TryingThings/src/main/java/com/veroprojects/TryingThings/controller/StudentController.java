package com.veroprojects.TryingThings.controller;


import com.veroprojects.TryingThings.controller.modelDTO.StudentIdDTO;
import com.veroprojects.TryingThings.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

        @PostMapping("/student")
        public ResponseEntity<StudentIdDTO> createStudent(@RequestBody final Student student) {
                System.out.println(student);
                StudentIdDTO result = new StudentIdDTO("1");
                return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(result);
        }


        @GetMapping("/student")
        public List<Student> getAllStudents() {
                List<Student> result = new ArrayList<Student>();
                Student student1 = new Student("1", "Romi", new BigDecimal("2323"));
                result.add(student1);
                Student student2 = new Student("2", "Lore", new BigDecimal("45454"));
                result.add(student2);
                Student student3 = new Student("2", "Lia", new BigDecimal("676"));
                result.add(student3);
                return result;
        }

        @GetMapping("/student/{id}")
        public Student getStudentById(@PathVariable final String id) {
                Student student1 = new Student("1", "Romi", new BigDecimal("2323"));
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
