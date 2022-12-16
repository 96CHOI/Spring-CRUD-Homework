package com.dw.springcrudjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw.springcrudjpa.model.Student;
import com.dw.springcrudjpa.repository.ProcessRepo;

@RestController
public class ApiController {

    @Autowired
    ProcessRepo repo;

    // 전체조회
    @GetMapping("/api/v1/student")
    public List<Student> callAllsStudents() {
        return repo.findAll();
    }
}
