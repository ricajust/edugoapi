package com.edugo.edugoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edugo.edugoapi.models.Student;
import com.edugo.edugoapi.repositories.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

	@Autowired
	private final StudentRepository repository;

	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	public Optional<Student> getStudentById(Long id) {
		return repository.findById(id);
	}

	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	public void deleteStudent(Long id) {
		repository.deleteById(id);
	}
}
