package com.nauka.spring5.rest.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nauka.spring5.rest.api.domain.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("Jan", "Kowal"));
		students.add(new Student("Anna", "Mucha"));
		students.add(new Student("Piotr", "Nowak"));
		
		return students;
	}
}