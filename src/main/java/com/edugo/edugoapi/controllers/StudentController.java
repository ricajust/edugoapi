package com.edugo.edugoapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.edugo.edugoapi.models.Student;
import com.edugo.edugoapi.services.StudentService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}

	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id) {
		return service.getStudentById(id);
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		student.setId(id);
		return service.saveStudent(student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
	}
}
