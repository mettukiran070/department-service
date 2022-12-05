package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.exception.DepartmentNotFoundException;
import com.example.department.service.DepartmentService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("/")
    public ResponseEntity<Department> save(@RequestBody Department department) {
        log.info("inside DepartmentController :: save method");
        return new ResponseEntity<>(this.service.save(department), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Department>> getAll() {
        log.info("inside DepartmentController :: getAll method");
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable("id") Long id) {
        log.info("inside DepartmentController :: getById method");
        Department department = this.service.getById(id).orElseThrow(() -> new DepartmentNotFoundException());
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable("id") Long id, @RequestBody Department department) {
        log.info("inside DepartmentController :: update method");
        this.service.getById(id).orElseThrow(() -> new DepartmentNotFoundException());
        return new ResponseEntity<>(this.service.updateById(department), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id) {
        log.info("inside DepartmentController :: deleteById method");
        this.service.getById(id).orElseThrow(() -> new DepartmentNotFoundException());
        this.service.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
