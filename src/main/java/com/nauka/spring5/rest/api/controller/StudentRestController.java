package com.nauka.spring5.rest.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.nauka.spring5.rest.api.domain.Student;
import com.nauka.spring5.rest.api.exceptions.StudentErrorResponse;
import com.nauka.spring5.rest.api.exceptions.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;
	
	@PostConstruct 
	public void fillList() {
		students = new ArrayList<>();
		students.add(new Student("Jan", "Kowal"));
		students.add(new Student("Anna", "Mucha"));
		students.add(new Student("Piotr", "Nowak"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return this.students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if (studentId < 0 || studentId >= students.size())
			throw new StudentNotFoundException("Student not found: " + studentId);
		return this.students.get(studentId);
	}
}