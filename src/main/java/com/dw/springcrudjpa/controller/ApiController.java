package com.dw.springcrudjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // 학생등록
    @PostMapping("/api/v1/students")
	public Student callSaveStudent(@RequestBody Student student) {
		// save == insert
		student = repo.save(student);
		return student;
	}

    // 학생정보 상세 조회
    @GetMapping("/student/{studentNum}")
	public Student callStudentById(@PathVariable long studentNum) {
		return repo.findById(studentNum).get();
	}

    // 수정
	@PatchMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		// save == update or insert
		// 동일한 PK 값이 있으면 update!
		// 동일한 PK 값이 없으면 insert!
		student = repo.save(student);
		return student;
	}

    // 삭제
	@DeleteMapping("/student/{num}")
	public boolean callDeleteMember(@PathVariable long num) {

		// deleteById == delete
		// By == where
		try {
			repo.deleteById(num); // 리턴타입이 void
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
