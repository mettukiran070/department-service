package com.example.department.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class DepartmentExceptionController {

    @ExceptionHandler(value = DepartmentNotFoundException.class)
    public ResponseEntity<Object> exception(DepartmentNotFoundException exception) {
        log.error("inside DepartmentExceptionController :: exception method");
        return new ResponseEntity<>("Department Not Found", HttpStatus.NOT_FOUND);
    }
}
