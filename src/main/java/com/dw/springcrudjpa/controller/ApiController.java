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

import com.dw.springcrudjpa.model.Process;
import com.dw.springcrudjpa.model.Student;
import com.dw.springcrudjpa.repository.ProcessRepo;
import com.dw.springcrudjpa.repository.StudentRepo;

@RestController
public class ApiController {

    @Autowired
    StudentRepo repo;
	@Autowired
    ProcessRepo repos;

    // 학생 전체조회
    @GetMapping("/api/v1/student")
    public List<Student> callAllsStudents() {
        return repo.findAll();
    }

	// 과정 전체조회
    @GetMapping("/api/v1/process")
    public List<Process> callAllsProcess() {
        return repos.findAll();
    }

    // 학생등록
    @PostMapping("/api/v1/students")
	public Student callSaveStudent(@RequestBody Student student) {
		// save == insert
		student = repo.save(student);
		return student;
	}

	// 과정등록
    @PostMapping("/api/v1/processInsert")
	public Process callSaveProcess(@RequestBody Process process) {
		// save == insert
		process = repos.save(process);
		return process;
	}

	// 학생정보 상세 조회
    @GetMapping("/student/{studentNum}")
	public Student callStudentById(@PathVariable long studentNum) {
		return repo.findById(studentNum).get();
	}

    // 과정정보 상세 조회
    @GetMapping("/process/{processNum}")
	public Process callProcessById(@PathVariable long processNum) {
		return repos.findById(processNum).get();
	}

	

    //학생목록 수정
	@PatchMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		// save == update or insert
		// 동일한 PK 값이 있으면 update!
		// 동일한 PK 값이 없으면 insert!
		student = repo.save(student);
		return student;
	}

	//과정목록 수정
	@PatchMapping("/process")
	public Process updateStudent(@RequestBody Process process) {
		// save == update or insert
		// 동일한 PK 값이 있으면 update!
		// 동일한 PK 값이 없으면 insert!
		process = repos.save(process);
		return process;
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
