package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department save(Department department) {
        log.info("inside DepartmentService :: save method.");
        return this.repository.save(department);
    }

    public List<Department> getAll(){
        log.info("inside DepartmentService :: getAll method.");
        return this.repository.findAll();
    }

    public Optional<Department> getById(Long id) {
        log.info("inside DepartmentService :: getById method.");
        return this.repository.findById(id);
    }

    public Department updateById(Department department) {
        log.info("inside DepartmentService :: updateById method.");
        return this.repository.save(department);
    }

    public void deleteById(Long id) {
        log.info("inside DepartmentService :: deleteById method.");
        this.repository.deleteById(id);
    }

}
