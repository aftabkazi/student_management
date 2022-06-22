package com.studentmanagement.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.studentmanagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	public Student findByStudentId(Long id);
}
