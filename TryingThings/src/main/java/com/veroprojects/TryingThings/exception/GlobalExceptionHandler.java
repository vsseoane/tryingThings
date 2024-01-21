package com.veroprojects.TryingThings.exception;

import com.veroprojects.TryingThings.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorDto> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();

        errorDto.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorDto.setMessage(ex.getMessage());
        errorDto.setTimestamp(new Date());

        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.NOT_FOUND);
    }

}
