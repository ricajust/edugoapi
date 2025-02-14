package com.edugo.edugoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edugo.edugoapi.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
